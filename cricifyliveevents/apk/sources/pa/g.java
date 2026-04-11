package pa;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g extends ka.g {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final RectF f10065r;

    public g(ka.m mVar, RectF rectF) {
        super(mVar);
        this.f10065r = rectF;
    }

    @Override // ka.g, android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        h hVar = new h(this);
        hVar.f10067c0 = this;
        hVar.invalidateSelf();
        return hVar;
    }

    public g(g gVar) {
        super(gVar);
        this.f10065r = gVar.f10065r;
    }
}
