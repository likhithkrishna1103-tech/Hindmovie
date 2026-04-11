package v4;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class i0 extends ViewGroup.MarginLayoutParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public x0 f13261a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Rect f13262b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f13263c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f13264d;

    public i0(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13262b = new Rect();
        this.f13263c = true;
        this.f13264d = false;
    }

    public i0(int i, int i10) {
        super(i, i10);
        this.f13262b = new Rect();
        this.f13263c = true;
        this.f13264d = false;
    }

    public i0(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
        this.f13262b = new Rect();
        this.f13263c = true;
        this.f13264d = false;
    }

    public i0(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.f13262b = new Rect();
        this.f13263c = true;
        this.f13264d = false;
    }

    public i0(i0 i0Var) {
        super((ViewGroup.LayoutParams) i0Var);
        this.f13262b = new Rect();
        this.f13263c = true;
        this.f13264d = false;
    }
}
