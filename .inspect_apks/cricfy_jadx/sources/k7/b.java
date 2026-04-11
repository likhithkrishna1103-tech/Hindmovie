package k7;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends Drawable implements e, Animatable {
    public int A;
    public boolean C;
    public Paint D;
    public Rect E;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ba.a f7212v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f7213w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f7214x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f7215y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f7216z = true;
    public final int B = -1;

    public b(ba.a aVar) {
        this.f7212v = aVar;
    }

    public final void a() {
        s7.f.a("You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.", !this.f7215y);
        g gVar = (g) this.f7212v.f1841b;
        if (gVar.f7225a.f13487l.f13467c == 1) {
            invalidateSelf();
            return;
        }
        if (this.f7213w) {
            return;
        }
        this.f7213w = true;
        ArrayList arrayList = gVar.f7227c;
        if (gVar.f7232j) {
            throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
        }
        if (arrayList.contains(this)) {
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
        boolean zIsEmpty = arrayList.isEmpty();
        arrayList.add(this);
        if (zIsEmpty && !gVar.f) {
            gVar.f = true;
            gVar.f7232j = false;
            gVar.a();
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        if (this.f7215y) {
            return;
        }
        if (this.C) {
            int intrinsicWidth = getIntrinsicWidth();
            int intrinsicHeight = getIntrinsicHeight();
            Rect bounds = getBounds();
            if (this.E == null) {
                this.E = new Rect();
            }
            Gravity.apply(119, intrinsicWidth, intrinsicHeight, bounds, this.E);
            this.C = false;
        }
        g gVar = (g) this.f7212v.f1841b;
        d dVar = gVar.i;
        Bitmap bitmap = dVar != null ? dVar.B : gVar.f7234l;
        if (this.E == null) {
            this.E = new Rect();
        }
        Rect rect = this.E;
        if (this.D == null) {
            this.D = new Paint(2);
        }
        canvas.drawBitmap(bitmap, (Rect) null, rect, this.D);
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        return this.f7212v;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return ((g) this.f7212v.f1841b).f7238p;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return ((g) this.f7212v.f1841b).f7237o;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        return this.f7213w;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.C = true;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        if (this.D == null) {
            this.D = new Paint(2);
        }
        this.D.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        if (this.D == null) {
            this.D = new Paint(2);
        }
        this.D.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z10, boolean z11) {
        s7.f.a("Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.", !this.f7215y);
        this.f7216z = z10;
        if (!z10) {
            this.f7213w = false;
            g gVar = (g) this.f7212v.f1841b;
            ArrayList arrayList = gVar.f7227c;
            arrayList.remove(this);
            if (arrayList.isEmpty()) {
                gVar.f = false;
            }
        } else if (this.f7214x) {
            a();
        }
        return super.setVisible(z10, z11);
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        this.f7214x = true;
        this.A = 0;
        if (this.f7216z) {
            a();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        this.f7214x = false;
        this.f7213w = false;
        g gVar = (g) this.f7212v.f1841b;
        ArrayList arrayList = gVar.f7227c;
        arrayList.remove(this);
        if (arrayList.isEmpty()) {
            gVar.f = false;
        }
    }
}
