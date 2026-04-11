package i9;

import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.google.android.material.imageview.ShapeableImageView;
import q9.g;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a extends ViewOutlineProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Rect f6467a = new Rect();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ShapeableImageView f6468b;

    public a(ShapeableImageView shapeableImageView) {
        this.f6468b = shapeableImageView;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View view, Outline outline) {
        ShapeableImageView shapeableImageView = this.f6468b;
        if (shapeableImageView.F == null) {
            return;
        }
        if (shapeableImageView.E == null) {
            shapeableImageView.E = new g(shapeableImageView.F);
        }
        RectF rectF = shapeableImageView.f3455y;
        Rect rect = this.f6467a;
        rectF.round(rect);
        shapeableImageView.E.setBounds(rect);
        shapeableImageView.E.getOutline(outline);
    }
}
