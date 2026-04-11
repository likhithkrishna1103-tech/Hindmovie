package ha;

import android.graphics.Typeface;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends k0.b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ com.bumptech.glide.d f5851h;
    public final /* synthetic */ d i;

    public b(d dVar, com.bumptech.glide.d dVar2) {
        this.i = dVar;
        this.f5851h = dVar2;
    }

    @Override // k0.b
    public final void h(int i) {
        this.i.f5867n = true;
        this.f5851h.w(i);
    }

    @Override // k0.b
    public final void i(Typeface typeface) {
        d dVar = this.i;
        dVar.f5869p = Typeface.create(typeface, dVar.f5859d);
        dVar.f5867n = true;
        this.f5851h.x(dVar.f5869p, false);
    }
}
