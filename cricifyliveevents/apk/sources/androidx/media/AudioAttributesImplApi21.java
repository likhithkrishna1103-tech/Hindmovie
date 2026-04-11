package androidx.media;

import android.media.AudioAttributes;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class AudioAttributesImplApi21 implements AudioAttributesImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AudioAttributes f1221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1222b = -1;

    public final boolean equals(Object obj) {
        if (obj instanceof AudioAttributesImplApi21) {
            return this.f1221a.equals(((AudioAttributesImplApi21) obj).f1221a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f1221a.hashCode();
    }

    public final String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.f1221a;
    }
}
