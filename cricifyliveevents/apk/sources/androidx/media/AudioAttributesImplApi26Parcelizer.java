package androidx.media;

import android.media.AudioAttributes;
import n5.b;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class AudioAttributesImplApi26Parcelizer {
    public static AudioAttributesImplApi26 read(b bVar) {
        AudioAttributesImplApi26 audioAttributesImplApi26 = new AudioAttributesImplApi26();
        audioAttributesImplApi26.f1221a = (AudioAttributes) bVar.g(audioAttributesImplApi26.f1221a, 1);
        audioAttributesImplApi26.f1222b = bVar.f(audioAttributesImplApi26.f1222b, 2);
        return audioAttributesImplApi26;
    }

    public static void write(AudioAttributesImplApi26 audioAttributesImplApi26, b bVar) {
        bVar.getClass();
        bVar.k(audioAttributesImplApi26.f1221a, 1);
        bVar.j(audioAttributesImplApi26.f1222b, 2);
    }
}
