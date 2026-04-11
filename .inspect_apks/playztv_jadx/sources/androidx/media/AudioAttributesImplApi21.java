package androidx.media;

import android.media.AudioAttributes;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class AudioAttributesImplApi21 implements AudioAttributesImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AudioAttributes f1525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1526b = -1;

    public final boolean equals(Object obj) {
        if (obj instanceof AudioAttributesImplApi21) {
            return this.f1525a.equals(((AudioAttributesImplApi21) obj).f1525a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f1525a.hashCode();
    }

    public final String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.f1525a;
    }
}
