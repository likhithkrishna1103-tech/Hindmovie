package g2;

import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ta.l f4644a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f4645b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public o0 f4646c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public v1.c f4647d;
    public int f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public w1.c f4650h;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f4649g = 1.0f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f4648e = 0;

    public d(Context context, Looper looper, o0 o0Var) {
        this.f4644a = com.bumptech.glide.f.E(new c(context, 0));
        this.f4646c = o0Var;
        this.f4645b = new Handler(looper);
    }

    public final void a() {
        int i = this.f4648e;
        if (i == 1 || i == 0 || this.f4650h == null) {
            return;
        }
        AudioManager audioManager = (AudioManager) this.f4644a.get();
        w1.c cVar = this.f4650h;
        if (Build.VERSION.SDK_INT < 26) {
            audioManager.abandonAudioFocus(cVar.f13781b);
            return;
        }
        Object obj = cVar.f;
        obj.getClass();
        audioManager.abandonAudioFocusRequest(w1.a.e(obj));
    }

    public final void b(int i) {
        o0 o0Var = this.f4646c;
        if (o0Var != null) {
            y1.x xVar = o0Var.C;
            xVar.getClass();
            y1.w wVarB = y1.x.b();
            wVarB.f14616a = xVar.f14618a.obtainMessage(33, i, 0);
            wVarB.b();
        }
    }

    public final void c(int i) {
        if (this.f4648e == i) {
            return;
        }
        this.f4648e = i;
        float f = i == 4 ? 0.2f : 1.0f;
        if (this.f4649g == f) {
            return;
        }
        this.f4649g = f;
        o0 o0Var = this.f4646c;
        if (o0Var != null) {
            o0Var.C.e(34);
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
        throw new UnsupportedOperationException("Method not decompiled: g2.d.d(int, boolean):int");
    }
}
