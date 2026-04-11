package p6;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import x6.m;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d implements u6.d {
    public Bitmap A;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f10220u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f10221v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public t6.c f10222w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Handler f10223x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f10224y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final long f10225z;

    public d(Handler handler, int i, long j5) {
        if (!m.i(Integer.MIN_VALUE, Integer.MIN_VALUE)) {
            throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: -2147483648 and height: -2147483648");
        }
        this.f10220u = Integer.MIN_VALUE;
        this.f10221v = Integer.MIN_VALUE;
        this.f10223x = handler;
        this.f10224y = i;
        this.f10225z = j5;
    }

    @Override // u6.d
    public final void a(Object obj) {
        this.A = (Bitmap) obj;
        Handler handler = this.f10223x;
        handler.sendMessageAtTime(handler.obtainMessage(1, this), this.f10225z);
    }

    @Override // u6.d
    public final void b(t6.h hVar) throws Throwable {
        hVar.m(this.f10220u, this.f10221v);
    }

    @Override // u6.d
    public final t6.c g() {
        return this.f10222w;
    }

    @Override // u6.d
    public final void h(Drawable drawable) {
        this.A = null;
    }

    @Override // u6.d
    public final void j(t6.c cVar) {
        this.f10222w = cVar;
    }

    @Override // com.bumptech.glide.manager.h
    public final void d() {
    }

    @Override // com.bumptech.glide.manager.h
    public final void l() {
    }

    @Override // com.bumptech.glide.manager.h
    public final void m() {
    }

    @Override // u6.d
    public final void c(Drawable drawable) {
    }

    @Override // u6.d
    public final void e(Drawable drawable) {
    }

    @Override // u6.d
    public final void k(t6.h hVar) {
    }
}
