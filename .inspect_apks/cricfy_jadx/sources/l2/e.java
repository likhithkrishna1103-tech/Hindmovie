package l2;

import android.os.Handler;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e implements m {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final k f7656v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public h f7657w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f7658x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ f f7659y;

    public e(f fVar, k kVar) {
        this.f7659y = fVar;
        this.f7656v = kVar;
    }

    @Override // l2.m
    public final void release() {
        Handler handler = this.f7659y.O;
        handler.getClass();
        y1.a0.S(handler, new androidx.emoji2.text.w(20, this));
    }
}
