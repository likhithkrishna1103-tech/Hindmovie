package a2;

import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z9.l f212a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f213b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public x0 f214c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public p1.d f215d;
    public int f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public q1.b f218h;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f217g = 1.0f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f216e = 0;

    public f(Context context, Looper looper, x0 x0Var) {
        this.f212a = z7.a.t(new e(context, 0));
        this.f214c = x0Var;
        this.f213b = new Handler(looper);
    }

    public final void a() {
        int i = this.f216e;
        if (i == 1 || i == 0 || this.f218h == null) {
            return;
        }
        AudioManager audioManager = (AudioManager) this.f212a.get();
        q1.b bVar = this.f218h;
        if (Build.VERSION.SDK_INT < 26) {
            audioManager.abandonAudioFocus(bVar.f10529b);
            return;
        }
        Object obj = bVar.f;
        obj.getClass();
        audioManager.abandonAudioFocusRequest(lb.h.l(obj));
    }

    public final void b(int i) {
        x0 x0Var = this.f214c;
        if (x0Var != null) {
            s1.y yVar = x0Var.B;
            yVar.getClass();
            s1.x xVarB = s1.y.b();
            xVarB.f11716a = yVar.f11718a.obtainMessage(33, i, 0);
            xVarB.b();
        }
    }

    public final void c(int i) {
        if (this.f216e == i) {
            return;
        }
        this.f216e = i;
        float f = i == 4 ? 0.2f : 1.0f;
        if (this.f217g == f) {
            return;
        }
        this.f217g = f;
        x0 x0Var = this.f214c;
        if (x0Var != null) {
            x0Var.B.e(34);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int d(int r13, boolean r14) {
        /*
            Method dump skipped, instruction units count: 220
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.f.d(int, boolean):int");
    }
}
