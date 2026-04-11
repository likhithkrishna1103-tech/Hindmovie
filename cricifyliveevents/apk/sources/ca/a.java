package ca;

import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.google.android.material.imageview.ShapeableImageView;
import ka.i;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends ViewOutlineProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Rect f2123a = new Rect();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ShapeableImageView f2124b;

    public a(ShapeableImageView shapeableImageView) {
        this.f2124b = shapeableImageView;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View view, Outline outline) {
        ShapeableImageView shapeableImageView = this.f2124b;
        if (shapeableImageView.G == null) {
            return;
        }
        if (shapeableImageView.F == null) {
            shapeableImageView.F = new i(shapeableImageView.G);
        }
        RectF rectF = shapeableImageView.f2918z;
        Rect rect = this.f2123a;
        rectF.round(rect);
        shapeableImageView.F.setBounds(rect);
        shapeableImageView.F.getOutline(outline);
    }
}
