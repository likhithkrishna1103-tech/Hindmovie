package l4;

import android.media.AudioAttributes;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AudioAttributes f7699a;

    public b(AudioAttributes audioAttributes) {
        this.f7699a = audioAttributes;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof b) {
            return Objects.equals(this.f7699a, ((b) obj).f7699a);
        }
        return false;
    }

    public final int hashCode() {
        AudioAttributes audioAttributes = this.f7699a;
        audioAttributes.getClass();
        return audioAttributes.hashCode();
    }

    public final String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.f7699a;
    }
}
