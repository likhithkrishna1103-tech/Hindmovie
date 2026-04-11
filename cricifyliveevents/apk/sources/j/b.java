package j;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.util.StateSet;
import v.h;
import v.i;
import v.l;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends Drawable.ConstantState {
    public boolean A;
    public ColorFilter B;
    public boolean C;
    public ColorStateList D;
    public PorterDuff.Mode E;
    public boolean F;
    public boolean G;
    public int[][] H;
    public h I;
    public l J;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f6454a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Resources f6455b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f6456c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f6457d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f6458e;
    public SparseArray f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Drawable[] f6459g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f6460h;
    public boolean i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f6461j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Rect f6462k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f6463l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f6464m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f6465n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f6466o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f6467p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f6468q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f6469r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f6470s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f6471t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f6472u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f6473v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f6474w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f6475x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f6476y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f6477z;

    public b(b bVar, e eVar, Resources resources) {
        this.i = false;
        this.f6463l = false;
        this.f6474w = true;
        this.f6476y = 0;
        this.f6477z = 0;
        this.f6454a = eVar;
        this.f6455b = resources != null ? resources : bVar != null ? bVar.f6455b : null;
        int i = bVar != null ? bVar.f6456c : 0;
        int i10 = e.O;
        i = resources != null ? resources.getDisplayMetrics().densityDpi : i;
        i = i == 0 ? 160 : i;
        this.f6456c = i;
        if (bVar != null) {
            this.f6457d = bVar.f6457d;
            this.f6458e = bVar.f6458e;
            this.f6472u = true;
            this.f6473v = true;
            this.i = bVar.i;
            this.f6463l = bVar.f6463l;
            this.f6474w = bVar.f6474w;
            this.f6475x = bVar.f6475x;
            this.f6476y = bVar.f6476y;
            this.f6477z = bVar.f6477z;
            this.A = bVar.A;
            this.B = bVar.B;
            this.C = bVar.C;
            this.D = bVar.D;
            this.E = bVar.E;
            this.F = bVar.F;
            this.G = bVar.G;
            if (bVar.f6456c == i) {
                if (bVar.f6461j) {
                    this.f6462k = bVar.f6462k != null ? new Rect(bVar.f6462k) : null;
                    this.f6461j = true;
                }
                if (bVar.f6464m) {
                    this.f6465n = bVar.f6465n;
                    this.f6466o = bVar.f6466o;
                    this.f6467p = bVar.f6467p;
                    this.f6468q = bVar.f6468q;
                    this.f6464m = true;
                }
            }
            if (bVar.f6469r) {
                this.f6470s = bVar.f6470s;
                this.f6469r = true;
            }
            if (bVar.f6471t) {
                this.f6471t = true;
            }
            Drawable[] drawableArr = bVar.f6459g;
            this.f6459g = new Drawable[drawableArr.length];
            this.f6460h = bVar.f6460h;
            SparseArray sparseArray = bVar.f;
            if (sparseArray != null) {
                this.f = sparseArray.clone();
            } else {
                this.f = new SparseArray(this.f6460h);
            }
            int i11 = this.f6460h;
            for (int i12 = 0; i12 < i11; i12++) {
                Drawable drawable = drawableArr[i12];
                if (drawable != null) {
                    Drawable.ConstantState constantState = drawable.getConstantState();
                    if (constantState != null) {
                        this.f.put(i12, constantState);
                    } else {
                        this.f6459g[i12] = drawableArr[i12];
                    }
                }
            }
        } else {
            this.f6459g = new Drawable[10];
            this.f6460h = 0;
        }
        if (bVar != null) {
            this.H = bVar.H;
        } else {
            this.H = new int[this.f6459g.length][];
        }
        if (bVar != null) {
            this.I = bVar.I;
            this.J = bVar.J;
        } else {
            this.I = new h();
            this.J = new l();
        }
    }

    public final int a(Drawable drawable) {
        int i = this.f6460h;
        if (i >= this.f6459g.length) {
            int i10 = i + 10;
            Drawable[] drawableArr = new Drawable[i10];
            Drawable[] drawableArr2 = this.f6459g;
            if (drawableArr2 != null) {
                System.arraycopy(drawableArr2, 0, drawableArr, 0, i);
            }
            this.f6459g = drawableArr;
            int[][] iArr = new int[i10][];
            System.arraycopy(this.H, 0, iArr, 0, i);
            this.H = iArr;
        }
        drawable.mutate();
        drawable.setVisible(false, true);
        drawable.setCallback(this.f6454a);
        this.f6459g[i] = drawable;
        this.f6460h++;
        this.f6458e = drawable.getChangingConfigurations() | this.f6458e;
        this.f6469r = false;
        this.f6471t = false;
        this.f6462k = null;
        this.f6461j = false;
        this.f6464m = false;
        this.f6472u = false;
        return i;
    }

    public final void b() {
        this.f6464m = true;
        c();
        int i = this.f6460h;
        Drawable[] drawableArr = this.f6459g;
        this.f6466o = -1;
        this.f6465n = -1;
        this.f6468q = 0;
        this.f6467p = 0;
        for (int i10 = 0; i10 < i; i10++) {
            Drawable drawable = drawableArr[i10];
            int intrinsicWidth = drawable.getIntrinsicWidth();
            if (intrinsicWidth > this.f6465n) {
                this.f6465n = intrinsicWidth;
            }
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicHeight > this.f6466o) {
                this.f6466o = intrinsicHeight;
            }
            int minimumWidth = drawable.getMinimumWidth();
            if (minimumWidth > this.f6467p) {
                this.f6467p = minimumWidth;
            }
            int minimumHeight = drawable.getMinimumHeight();
            if (minimumHeight > this.f6468q) {
                this.f6468q = minimumHeight;
            }
        }
    }

    public final void c() {
        SparseArray sparseArray = this.f;
        if (sparseArray != null) {
            int size = sparseArray.size();
            for (int i = 0; i < size; i++) {
                int iKeyAt = this.f.keyAt(i);
                Drawable.ConstantState constantState = (Drawable.ConstantState) this.f.valueAt(i);
                Drawable[] drawableArr = this.f6459g;
                Drawable drawableNewDrawable = constantState.newDrawable(this.f6455b);
                drawableNewDrawable.setLayoutDirection(this.f6475x);
                Drawable drawableMutate = drawableNewDrawable.mutate();
                drawableMutate.setCallback(this.f6454a);
                drawableArr[iKeyAt] = drawableMutate;
            }
            this.f = null;
        }
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final boolean canApplyTheme() {
        int i = this.f6460h;
        Drawable[] drawableArr = this.f6459g;
        for (int i10 = 0; i10 < i; i10++) {
            Drawable drawable = drawableArr[i10];
            if (drawable == null) {
                Drawable.ConstantState constantState = (Drawable.ConstantState) this.f.get(i10);
                if (constantState != null && constantState.canApplyTheme()) {
                    return true;
                }
            } else if (drawable.canApplyTheme()) {
                return true;
            }
        }
        return false;
    }

    public final Drawable d(int i) {
        int iIndexOfKey;
        Drawable drawable = this.f6459g[i];
        if (drawable != null) {
            return drawable;
        }
        SparseArray sparseArray = this.f;
        if (sparseArray == null || (iIndexOfKey = sparseArray.indexOfKey(i)) < 0) {
            return null;
        }
        Drawable drawableNewDrawable = ((Drawable.ConstantState) this.f.valueAt(iIndexOfKey)).newDrawable(this.f6455b);
        drawableNewDrawable.setLayoutDirection(this.f6475x);
        Drawable drawableMutate = drawableNewDrawable.mutate();
        drawableMutate.setCallback(this.f6454a);
        this.f6459g[i] = drawableMutate;
        this.f.removeAt(iIndexOfKey);
        if (this.f.size() == 0) {
            this.f = null;
        }
        return drawableMutate;
    }

    public final int e(int i) {
        Object obj;
        if (i < 0) {
            return 0;
        }
        l lVar = this.J;
        Object obj2 = 0;
        int iA = w.a.a(lVar.f12546y, i, lVar.f12544w);
        if (iA >= 0 && (obj = lVar.f12545x[iA]) != i.f12533b) {
            obj2 = obj;
        }
        return ((Integer) obj2).intValue();
    }

    public final int f(int[] iArr) {
        int[][] iArr2 = this.H;
        int i = this.f6460h;
        for (int i10 = 0; i10 < i; i10++) {
            if (StateSet.stateSetMatches(iArr2[i10], iArr)) {
                return i10;
            }
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        return this.f6457d | this.f6458e;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        return new e(this, null);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable(Resources resources) {
        return new e(this, resources);
    }
}
