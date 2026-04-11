package androidx.media;

import android.media.AudioAttributes;
import i5.b;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class AudioAttributesImplApi21Parcelizer {
    public static AudioAttributesImplApi21 read(b bVar) {
        AudioAttributesImplApi21 audioAttributesImplApi21 = new AudioAttributesImplApi21();
        audioAttributesImplApi21.f1525a = (AudioAttributes) bVar.g(audioAttributesImplApi21.f1525a, 1);
        audioAttributesImplApi21.f1526b = bVar.f(audioAttributesImplApi21.f1526b, 2);
        return audioAttributesImplApi21;
    }

    public static void write(AudioAttributesImplApi21 audioAttributesImplApi21, b bVar) {
        bVar.getClass();
        bVar.k(audioAttributesImplApi21.f1525a, 1);
        bVar.j(audioAttributesImplApi21.f1526b, 2);
    }
}
