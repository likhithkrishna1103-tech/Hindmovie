package k7;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import s7.m;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements p7.d {
    public final long A;
    public Bitmap B;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f7218v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f7219w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public o7.c f7220x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Handler f7221y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f7222z;

    public d(Handler handler, int i, long j4) {
        if (!m.i(Integer.MIN_VALUE, Integer.MIN_VALUE)) {
            throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: -2147483648 and height: -2147483648");
        }
        this.f7218v = Integer.MIN_VALUE;
        this.f7219w = Integer.MIN_VALUE;
        this.f7221y = handler;
        this.f7222z = i;
        this.A = j4;
    }

    @Override // p7.d
    public final void a(Object obj) {
        this.B = (Bitmap) obj;
        Handler handler = this.f7221y;
        handler.sendMessageAtTime(handler.obtainMessage(1, this), this.A);
    }

    @Override // p7.d
    public final void d(o7.c cVar) {
        this.f7220x = cVar;
    }

    @Override // p7.d
    public final void e(o7.h hVar) throws Throwable {
        hVar.m(this.f7218v, this.f7219w);
    }

    @Override // p7.d
    public final o7.c j() {
        return this.f7220x;
    }

    @Override // p7.d
    public final void k(Drawable drawable) {
        this.B = null;
    }

    @Override // com.bumptech.glide.manager.h
    public final void c() {
    }

    @Override // com.bumptech.glide.manager.h
    public final void l() {
    }

    @Override // com.bumptech.glide.manager.h
    public final void m() {
    }

    @Override // p7.d
    public final void b(Drawable drawable) {
    }

    @Override // p7.d
    public final void f(o7.h hVar) {
    }

    @Override // p7.d
    public final void g(Drawable drawable) {
    }
}
