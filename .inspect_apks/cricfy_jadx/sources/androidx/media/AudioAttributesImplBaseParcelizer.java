package androidx.media;

import n5.b;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class AudioAttributesImplBaseParcelizer {
    public static AudioAttributesImplBase read(b bVar) {
        AudioAttributesImplBase audioAttributesImplBase = new AudioAttributesImplBase();
        audioAttributesImplBase.f1223a = bVar.f(audioAttributesImplBase.f1223a, 1);
        audioAttributesImplBase.f1224b = bVar.f(audioAttributesImplBase.f1224b, 2);
        audioAttributesImplBase.f1225c = bVar.f(audioAttributesImplBase.f1225c, 3);
        audioAttributesImplBase.f1226d = bVar.f(audioAttributesImplBase.f1226d, 4);
        return audioAttributesImplBase;
    }

    public static void write(AudioAttributesImplBase audioAttributesImplBase, b bVar) {
        bVar.getClass();
        bVar.j(audioAttributesImplBase.f1223a, 1);
        bVar.j(audioAttributesImplBase.f1224b, 2);
        bVar.j(audioAttributesImplBase.f1225c, 3);
        bVar.j(audioAttributesImplBase.f1226d, 4);
    }
}
