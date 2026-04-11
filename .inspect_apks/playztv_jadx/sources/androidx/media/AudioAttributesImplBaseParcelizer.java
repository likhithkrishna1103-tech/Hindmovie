package androidx.media;

import i5.b;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class AudioAttributesImplBaseParcelizer {
    public static AudioAttributesImplBase read(b bVar) {
        AudioAttributesImplBase audioAttributesImplBase = new AudioAttributesImplBase();
        audioAttributesImplBase.f1527a = bVar.f(audioAttributesImplBase.f1527a, 1);
        audioAttributesImplBase.f1528b = bVar.f(audioAttributesImplBase.f1528b, 2);
        audioAttributesImplBase.f1529c = bVar.f(audioAttributesImplBase.f1529c, 3);
        audioAttributesImplBase.f1530d = bVar.f(audioAttributesImplBase.f1530d, 4);
        return audioAttributesImplBase;
    }

    public static void write(AudioAttributesImplBase audioAttributesImplBase, b bVar) {
        bVar.getClass();
        bVar.j(audioAttributesImplBase.f1527a, 1);
        bVar.j(audioAttributesImplBase.f1528b, 2);
        bVar.j(audioAttributesImplBase.f1529c, 3);
        bVar.j(audioAttributesImplBase.f1530d, 4);
    }
}
