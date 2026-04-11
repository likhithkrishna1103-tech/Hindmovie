package ha;

import android.graphics.Typeface;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends com.bumptech.glide.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Typeface f5848a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p6.c f5849b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f5850c;

    public a(p6.c cVar, Typeface typeface) {
        this.f5848a = typeface;
        this.f5849b = cVar;
    }

    @Override // com.bumptech.glide.d
    public final void w(int i) {
        if (this.f5850c) {
            return;
        }
        da.c cVar = (da.c) this.f5849b.f10035w;
        if (cVar.l(this.f5848a)) {
            cVar.j(false);
        }
    }

    @Override // com.bumptech.glide.d
    public final void x(Typeface typeface, boolean z10) {
        if (this.f5850c) {
            return;
        }
        da.c cVar = (da.c) this.f5849b.f10035w;
        if (cVar.l(typeface)) {
            cVar.j(false);
        }
    }
}
