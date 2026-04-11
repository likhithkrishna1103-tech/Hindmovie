package h4;

import android.media.AudioAttributes;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AudioAttributes f5788a;

    public a(AudioAttributes audioAttributes) {
        this.f5788a = audioAttributes;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof a) {
            return Objects.equals(this.f5788a, ((a) obj).f5788a);
        }
        return false;
    }

    public final int hashCode() {
        AudioAttributes audioAttributes = this.f5788a;
        audioAttributes.getClass();
        return audioAttributes.hashCode();
    }

    public final String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.f5788a;
    }
}
