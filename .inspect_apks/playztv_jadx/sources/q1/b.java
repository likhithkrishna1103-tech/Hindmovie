package q1;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f10528a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AudioManager.OnAudioFocusChangeListener f10529b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f10530c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final p1.d f10531d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f10532e;
    public final Object f;

    public b(int i, AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, Handler handler, p1.d dVar, boolean z2) {
        this.f10528a = i;
        this.f10530c = handler;
        this.f10531d = dVar;
        this.f10532e = z2;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 26) {
            this.f10529b = new a(onAudioFocusChangeListener, handler);
        } else {
            this.f10529b = onAudioFocusChangeListener;
        }
        if (i10 >= 26) {
            this.f = lb.h.g(i).setAudioAttributes((AudioAttributes) dVar.b().f10045a).setWillPauseWhenDucked(z2).setOnAudioFocusChangeListener(onAudioFocusChangeListener, handler).build();
        } else {
            this.f = null;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f10528a == bVar.f10528a && this.f10532e == bVar.f10532e && Objects.equals(this.f10529b, bVar.f10529b) && Objects.equals(this.f10530c, bVar.f10530c) && Objects.equals(this.f10531d, bVar.f10531d);
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.f10528a), this.f10529b, this.f10530c, this.f10531d, Boolean.valueOf(this.f10532e));
    }
}
