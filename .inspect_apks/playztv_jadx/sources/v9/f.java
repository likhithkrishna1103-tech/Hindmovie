package v9;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f extends q9.f {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final RectF f13353r;

    public f(q9.k kVar, RectF rectF) {
        super(kVar);
        this.f13353r = rectF;
    }

    @Override // q9.f, android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        g gVar = new g(this);
        gVar.S = this;
        gVar.invalidateSelf();
        return gVar;
    }

    public f(f fVar) {
        super(fVar);
        this.f13353r = fVar.f13353r;
    }
}
