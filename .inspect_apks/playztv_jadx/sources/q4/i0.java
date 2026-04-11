package q4;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class i0 extends ViewGroup.MarginLayoutParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public x0 f10831a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Rect f10832b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f10833c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f10834d;

    public i0(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10832b = new Rect();
        this.f10833c = true;
        this.f10834d = false;
    }

    public i0(int i, int i10) {
        super(i, i10);
        this.f10832b = new Rect();
        this.f10833c = true;
        this.f10834d = false;
    }

    public i0(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
        this.f10832b = new Rect();
        this.f10833c = true;
        this.f10834d = false;
    }

    public i0(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.f10832b = new Rect();
        this.f10833c = true;
        this.f10834d = false;
    }

    public i0(i0 i0Var) {
        super((ViewGroup.LayoutParams) i0Var);
        this.f10832b = new Rect();
        this.f10833c = true;
        this.f10834d = false;
    }
}
