package h5;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class p extends Drawable.ConstantState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public o f5932b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ColorStateList f5933c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public PorterDuff.Mode f5934d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f5935e;
    public Bitmap f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ColorStateList f5936g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public PorterDuff.Mode f5937h;
    public int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f5938j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f5939k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Paint f5940l;

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        return this.f5931a;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        return new r(this);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable(Resources resources) {
        return new r(this);
    }
}
