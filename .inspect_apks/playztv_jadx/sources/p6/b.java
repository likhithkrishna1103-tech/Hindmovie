package p6;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b extends Drawable implements e, Animatable {
    public boolean B;
    public Paint C;
    public Rect D;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final h5.e f10213u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f10214v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f10215w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f10216x;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f10218z;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f10217y = true;
    public final int A = -1;

    public b(h5.e eVar) {
        this.f10213u = eVar;
    }

    public final void a() {
        x6.f.a("You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.", !this.f10216x);
        g gVar = (g) this.f10213u.f5886b;
        if (gVar.f10228a.f602l.f582c == 1) {
            invalidateSelf();
            return;
        }
        if (this.f10214v) {
            return;
        }
        this.f10214v = true;
        ArrayList arrayList = gVar.f10230c;
        if (gVar.f10235j) {
            throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
        }
        if (arrayList.contains(this)) {
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
        boolean zIsEmpty = arrayList.isEmpty();
        arrayList.add(this);
        if (zIsEmpty && !gVar.f) {
            gVar.f = true;
            gVar.f10235j = false;
            gVar.a();
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        if (this.f10216x) {
            return;
        }
        if (this.B) {
            int intrinsicWidth = getIntrinsicWidth();
            int intrinsicHeight = getIntrinsicHeight();
            Rect bounds = getBounds();
            if (this.D == null) {
                this.D = new Rect();
            }
            Gravity.apply(119, intrinsicWidth, intrinsicHeight, bounds, this.D);
            this.B = false;
        }
        g gVar = (g) this.f10213u.f5886b;
        d dVar = gVar.i;
        Bitmap bitmap = dVar != null ? dVar.A : gVar.f10237l;
        if (this.D == null) {
            this.D = new Rect();
        }
        Rect rect = this.D;
        if (this.C == null) {
            this.C = new Paint(2);
        }
        canvas.drawBitmap(bitmap, (Rect) null, rect, this.C);
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        return this.f10213u;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return ((g) this.f10213u.f5886b).f10241p;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return ((g) this.f10213u.f5886b).f10240o;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        return this.f10214v;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.B = true;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        if (this.C == null) {
            this.C = new Paint(2);
        }
        this.C.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        if (this.C == null) {
            this.C = new Paint(2);
        }
        this.C.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z2, boolean z10) {
        x6.f.a("Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.", !this.f10216x);
        this.f10217y = z2;
        if (!z2) {
            this.f10214v = false;
            g gVar = (g) this.f10213u.f5886b;
            ArrayList arrayList = gVar.f10230c;
            arrayList.remove(this);
            if (arrayList.isEmpty()) {
                gVar.f = false;
            }
        } else if (this.f10215w) {
            a();
        }
        return super.setVisible(z2, z10);
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        this.f10215w = true;
        this.f10218z = 0;
        if (this.f10217y) {
            a();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        this.f10215w = false;
        this.f10214v = false;
        g gVar = (g) this.f10213u.f5886b;
        ArrayList arrayList = gVar.f10230c;
        arrayList.remove(this);
        if (arrayList.isEmpty()) {
            gVar.f = false;
        }
    }
}
