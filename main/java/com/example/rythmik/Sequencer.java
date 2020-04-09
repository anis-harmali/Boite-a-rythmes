package com.example.rythmik;

/*
    SOURCE : https://github.com/AndroidAalto/SoundFuse/tree/master/src/org/androidaalto/soundfuse/sequencer
 */

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

public class Sequencer {
    private int rows; // ligne du tablea (nb d'instrument)
    private int beats; // nb de tempo
    private int[] samples; // tableau contenant les sons
    private int maxBeats;
    private int maxRows;
    private int bpm;
    private SoundPool sound;
    private Context context;
    private Runnable playback;
    private boolean playing = false;
    private OnBPMListener mOnBPMListener;
    private Matrix matrix;

    public interface OnBPMListener {
        public void onBPM(int beatCount);
    }


    /**
     * constructeur.
     */

    public Sequencer(Context ctx, int nsamples, int nbeats) {
        context = ctx;
        rows = nsamples;
        beats = nbeats;
        bpm = 120;
        samples = new int[nsamples];
        sound = new SoundPool(nsamples, AudioManager.STREAM_MUSIC, 0);
        matrix = new Matrix(ctx, rows, beats);
        maxBeats = 20;

    }


    public void setSample(int id, int sampleSrc) {
        samples[id] = sound.load(context, sampleSrc, 1);
    }


    public void enableCell(int sampleId, int beatId) {
        matrix.setCellValue(sampleId, beatId, 1);
    }


    public void disableCell(int sampleId, int beatId) {
        matrix.setCellValue(sampleId, beatId, 0);
    }


    public void setOnBPMListener(OnBPMListener l) {
        this.mOnBPMListener = l;
    }

    public int getBpm() {
        return bpm;
    }

    public void setBpm(int bpm) {
        this.bpm = bpm;
    }

    public void addColumns(int ncol) {
        this.beats = this.beats + ncol;
    }

    public void deleteColumns(int ncol) {
        this.beats = this.beats - ncol;
    }

    public int getBeats() {
        return beats;
    }

    public void setBeats(int beats) {
        this.beats = beats;
    }

    public int getRows() {
        return rows;
    }

    public int getMaxBeats() {
        return maxBeats;
    }


    public void play() {

        playback = new Runnable() {
            int count = 0;

            public void run() {

                while (playing) {
                    if (mOnBPMListener != null)
                        mOnBPMListener.onBPM(count);
                    long millis = System.currentTimeMillis();
                    for (int i = 0; i < rows; i++) {
                        System.out.println("Row-COl " + i + "-" + count);
                        if (matrix.getCellValue(i, count) != 0)
                            sound.play(samples[i], 100, 100, 1, 0, 0);
                    }

                    count = (count + 1) % beats;
                    long next = (60 * 1000) / bpm;
                    try {
                        Thread.sleep(next - (System.currentTimeMillis() - millis));
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        };

        playing = true;
        Thread thandler = new Thread(playback);
        thandler.start();
    }


    public void stop() {
        playing = false;
    }


    public void toggle() {
        if (playing) {
            stop();
        } else {
            play();
        }
    }
}

