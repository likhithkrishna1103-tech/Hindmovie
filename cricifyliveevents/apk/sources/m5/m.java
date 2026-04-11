package m5;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class m extends Drawable.ConstantState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8357a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public l f8358b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ColorStateList f8359c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public PorterDuff.Mode f8360d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f8361e;
    public Bitmap f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ColorStateList f8362g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public PorterDuff.Mode f8363h;
    public int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f8364j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f8365k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Paint f8366l;

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        return this.f8357a;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        return new o(this);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable(Resources resources) {
        return new o(this);
    }
}
