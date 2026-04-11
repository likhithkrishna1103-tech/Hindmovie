package w1;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AudioManager.OnAudioFocusChangeListener f13781b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f13782c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final v1.c f13783d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f13784e;
    public final Object f;

    public c(int i, AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, Handler handler, v1.c cVar, boolean z10) {
        this.f13780a = i;
        this.f13782c = handler;
        this.f13783d = cVar;
        this.f13784e = z10;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 26) {
            this.f13781b = new b(onAudioFocusChangeListener, handler);
        } else {
            this.f13781b = onAudioFocusChangeListener;
        }
        if (i10 >= 26) {
            this.f = m9.a.f(i).setAudioAttributes((AudioAttributes) cVar.b().f12977a).setWillPauseWhenDucked(z10).setOnAudioFocusChangeListener(onAudioFocusChangeListener, handler).build();
        } else {
            this.f = null;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f13780a == cVar.f13780a && this.f13784e == cVar.f13784e && Objects.equals(this.f13781b, cVar.f13781b) && Objects.equals(this.f13782c, cVar.f13782c) && Objects.equals(this.f13783d, cVar.f13783d);
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.f13780a), this.f13781b, this.f13782c, this.f13783d, Boolean.valueOf(this.f13784e));
    }
}
