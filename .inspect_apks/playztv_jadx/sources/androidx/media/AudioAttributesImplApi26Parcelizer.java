package androidx.media;

import android.media.AudioAttributes;
import i5.b;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class AudioAttributesImplApi26Parcelizer {
    public static AudioAttributesImplApi26 read(b bVar) {
        AudioAttributesImplApi26 audioAttributesImplApi26 = new AudioAttributesImplApi26();
        audioAttributesImplApi26.f1525a = (AudioAttributes) bVar.g(audioAttributesImplApi26.f1525a, 1);
        audioAttributesImplApi26.f1526b = bVar.f(audioAttributesImplApi26.f1526b, 2);
        return audioAttributesImplApi26;
    }

    public static void write(AudioAttributesImplApi26 audioAttributesImplApi26, b bVar) {
        bVar.getClass();
        bVar.k(audioAttributesImplApi26.f1525a, 1);
        bVar.j(audioAttributesImplApi26.f1526b, 2);
    }
}
