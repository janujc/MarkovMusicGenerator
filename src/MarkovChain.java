import java.io.File;
import java.nio.file.*;
import java.util.*;
import javax.sound.midi.*;

public class MarkovChain {
    public static void main(String[] args) {
        String filename = "data/mozk246a.mid";
        File midiFile = new File(filename);

        Sequence sequence = MidiSystem.getSequence(midiFile);
        Sequencer sequencer = MidiSystem.getSequencer();

        sequencer.open();
        sequencer.setSequence(sequence);

        sequencer.start();

        System.out.println("Sequence file name: " + midiFile);

        if (sequence != null) {
            // Print sequence information
            System.out.println( " length: " +
                    sequence.getTickLength() + " ticks" );
            System.out.println( " duration: " +
                    sequence.getMicrosecondLength() +
                    " micro seconds" );
        }


//        try{
//            /* Create a new Sythesizer and open it. Most of
//             * the methods you will want to use to expand on this
//             * example can be found in the Java documentation here:
//             * https://docs.oracle.com/javase/7/docs/api/javax/sound/midi/Synthesizer.html
//             */
//            Synthesizer midiSynth = MidiSystem.getSynthesizer();
//            midiSynth.open();
//
//            //get and load default instrument and channel lists
//            Instrument[] instr = midiSynth.getDefaultSoundbank().getInstruments();
//            MidiChannel[] mChannels = midiSynth.getChannels();
//
//            midiSynth.loadInstrument(instr[0]);//load an instrument
//
//
//            mChannels[0].noteOn(60, 100);//On channel 0, play note number 60 with velocity 100
//            try { Thread.sleep(1000); // wait time in milliseconds to control duration
//            } catch( InterruptedException e ) { }
//            mChannels[0].noteOff(60);//turn of the note
//
//
//        } catch (MidiUnavailableException e) {}
    }
}
