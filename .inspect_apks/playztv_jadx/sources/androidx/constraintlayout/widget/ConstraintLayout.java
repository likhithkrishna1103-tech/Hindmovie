package androidx.constraintlayout.widget;

import a0.c;
import a0.d;
import a0.e;
import a0.f;
import a0.g;
import a0.h;
import a0.o;
import a0.p;
import a0.q;
import a0.s;
import a0.t;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import b1.j;
import com.google.android.gms.internal.measurement.k4;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParserException;
import x.i;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class ConstraintLayout extends ViewGroup {
    public static t L;
    public int A;
    public boolean B;
    public int C;
    public o D;
    public k4 E;
    public int F;
    public HashMap G;
    public final SparseArray H;
    public final f I;
    public int J;
    public int K;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final SparseArray f961u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ArrayList f962v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final x.f f963w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f964x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f965y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f966z;

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f961u = new SparseArray();
        this.f962v = new ArrayList(4);
        this.f963w = new x.f();
        this.f964x = 0;
        this.f965y = 0;
        this.f966z = Integer.MAX_VALUE;
        this.A = Integer.MAX_VALUE;
        this.B = true;
        this.C = 257;
        this.D = null;
        this.E = null;
        this.F = -1;
        this.G = new HashMap();
        this.H = new SparseArray();
        this.I = new f(this, this);
        this.J = 0;
        this.K = 0;
        i(attributeSet, 0);
    }

    public static e g() {
        e eVar = new e(-2, -2);
        eVar.f13a = -1;
        eVar.f15b = -1;
        eVar.f17c = -1.0f;
        eVar.f19d = true;
        eVar.f21e = -1;
        eVar.f = -1;
        eVar.f24g = -1;
        eVar.f26h = -1;
        eVar.i = -1;
        eVar.f29j = -1;
        eVar.f31k = -1;
        eVar.f33l = -1;
        eVar.f34m = -1;
        eVar.f36n = -1;
        eVar.f38o = -1;
        eVar.f40p = -1;
        eVar.f42q = 0;
        eVar.f43r = 0.0f;
        eVar.f44s = -1;
        eVar.f45t = -1;
        eVar.f46u = -1;
        eVar.f47v = -1;
        eVar.f48w = Integer.MIN_VALUE;
        eVar.f49x = Integer.MIN_VALUE;
        eVar.f50y = Integer.MIN_VALUE;
        eVar.f51z = Integer.MIN_VALUE;
        eVar.A = Integer.MIN_VALUE;
        eVar.B = Integer.MIN_VALUE;
        eVar.C = Integer.MIN_VALUE;
        eVar.D = 0;
        eVar.E = 0.5f;
        eVar.F = 0.5f;
        eVar.G = null;
        eVar.H = -1.0f;
        eVar.I = -1.0f;
        eVar.J = 0;
        eVar.K = 0;
        eVar.L = 0;
        eVar.M = 0;
        eVar.N = 0;
        eVar.O = 0;
        eVar.P = 0;
        eVar.Q = 0;
        eVar.R = 1.0f;
        eVar.S = 1.0f;
        eVar.T = -1;
        eVar.U = -1;
        eVar.V = -1;
        eVar.W = false;
        eVar.X = false;
        eVar.Y = null;
        eVar.Z = 0;
        eVar.f14a0 = true;
        eVar.f16b0 = true;
        eVar.f18c0 = false;
        eVar.f20d0 = false;
        eVar.f22e0 = false;
        eVar.f23f0 = -1;
        eVar.f25g0 = -1;
        eVar.f27h0 = -1;
        eVar.f28i0 = -1;
        eVar.f30j0 = Integer.MIN_VALUE;
        eVar.f32k0 = Integer.MIN_VALUE;
        eVar.l0 = 0.5f;
        eVar.f41p0 = new x.e();
        return eVar;
    }

    private int getPaddingWidth() {
        int iMax = Math.max(0, getPaddingRight()) + Math.max(0, getPaddingLeft());
        int iMax2 = Math.max(0, getPaddingEnd()) + Math.max(0, getPaddingStart());
        return iMax2 > 0 ? iMax2 : iMax;
    }

    public static t getSharedValues() {
        if (L == null) {
            t tVar = new t();
            new SparseIntArray();
            new HashMap();
            L = tVar;
        }
        return L;
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        Object tag;
        int size;
        ArrayList arrayList = this.f962v;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            for (int i = 0; i < size; i++) {
                ((c) arrayList.get(i)).getClass();
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            float width = getWidth();
            float height = getHeight();
            int childCount = getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = getChildAt(i10);
                if (childAt.getVisibility() != 8 && (tag = childAt.getTag()) != null && (tag instanceof String)) {
                    String[] strArrSplit = ((String) tag).split(",");
                    if (strArrSplit.length == 4) {
                        int i11 = Integer.parseInt(strArrSplit[0]);
                        int i12 = Integer.parseInt(strArrSplit[1]);
                        int i13 = Integer.parseInt(strArrSplit[2]);
                        int i14 = (int) ((i11 / 1080.0f) * width);
                        int i15 = (int) ((i12 / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f = i14;
                        float f4 = i15;
                        float f10 = i14 + ((int) ((i13 / 1080.0f) * width));
                        canvas.drawLine(f, f4, f10, f4, paint);
                        float f11 = i15 + ((int) ((Integer.parseInt(strArrSplit[3]) / 1920.0f) * height));
                        canvas.drawLine(f10, f4, f10, f11, paint);
                        canvas.drawLine(f10, f11, f, f11, paint);
                        canvas.drawLine(f, f11, f, f4, paint);
                        paint.setColor(-16711936);
                        canvas.drawLine(f, f4, f10, f11, paint);
                        canvas.drawLine(f, f11, f10, f4, paint);
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public final void forceLayout() {
        this.B = true;
        super.forceLayout();
    }

    @Override // android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return g();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        e eVar = new e(context, attributeSet);
        eVar.f13a = -1;
        eVar.f15b = -1;
        eVar.f17c = -1.0f;
        eVar.f19d = true;
        eVar.f21e = -1;
        eVar.f = -1;
        eVar.f24g = -1;
        eVar.f26h = -1;
        eVar.i = -1;
        eVar.f29j = -1;
        eVar.f31k = -1;
        eVar.f33l = -1;
        eVar.f34m = -1;
        eVar.f36n = -1;
        eVar.f38o = -1;
        eVar.f40p = -1;
        eVar.f42q = 0;
        eVar.f43r = 0.0f;
        eVar.f44s = -1;
        eVar.f45t = -1;
        eVar.f46u = -1;
        eVar.f47v = -1;
        eVar.f48w = Integer.MIN_VALUE;
        eVar.f49x = Integer.MIN_VALUE;
        eVar.f50y = Integer.MIN_VALUE;
        eVar.f51z = Integer.MIN_VALUE;
        eVar.A = Integer.MIN_VALUE;
        eVar.B = Integer.MIN_VALUE;
        eVar.C = Integer.MIN_VALUE;
        eVar.D = 0;
        eVar.E = 0.5f;
        eVar.F = 0.5f;
        eVar.G = null;
        eVar.H = -1.0f;
        eVar.I = -1.0f;
        eVar.J = 0;
        eVar.K = 0;
        eVar.L = 0;
        eVar.M = 0;
        eVar.N = 0;
        eVar.O = 0;
        eVar.P = 0;
        eVar.Q = 0;
        eVar.R = 1.0f;
        eVar.S = 1.0f;
        eVar.T = -1;
        eVar.U = -1;
        eVar.V = -1;
        eVar.W = false;
        eVar.X = false;
        eVar.Y = null;
        eVar.Z = 0;
        eVar.f14a0 = true;
        eVar.f16b0 = true;
        eVar.f18c0 = false;
        eVar.f20d0 = false;
        eVar.f22e0 = false;
        eVar.f23f0 = -1;
        eVar.f25g0 = -1;
        eVar.f27h0 = -1;
        eVar.f28i0 = -1;
        eVar.f30j0 = Integer.MIN_VALUE;
        eVar.f32k0 = Integer.MIN_VALUE;
        eVar.l0 = 0.5f;
        eVar.f41p0 = new x.e();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, s.ConstraintLayout_Layout);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i);
            int i10 = d.f12a.get(index);
            switch (i10) {
                case 1:
                    eVar.V = typedArrayObtainStyledAttributes.getInt(index, eVar.V);
                    break;
                case 2:
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, eVar.f40p);
                    eVar.f40p = resourceId;
                    if (resourceId == -1) {
                        eVar.f40p = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 3:
                    eVar.f42q = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, eVar.f42q);
                    break;
                case j.LONG_FIELD_NUMBER /* 4 */:
                    float f = typedArrayObtainStyledAttributes.getFloat(index, eVar.f43r) % 360.0f;
                    eVar.f43r = f;
                    if (f < 0.0f) {
                        eVar.f43r = (360.0f - f) % 360.0f;
                    }
                    break;
                case j.STRING_FIELD_NUMBER /* 5 */:
                    eVar.f13a = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, eVar.f13a);
                    break;
                case j.STRING_SET_FIELD_NUMBER /* 6 */:
                    eVar.f15b = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, eVar.f15b);
                    break;
                case j.DOUBLE_FIELD_NUMBER /* 7 */:
                    eVar.f17c = typedArrayObtainStyledAttributes.getFloat(index, eVar.f17c);
                    break;
                case 8:
                    int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, eVar.f21e);
                    eVar.f21e = resourceId2;
                    if (resourceId2 == -1) {
                        eVar.f21e = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 9:
                    int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(index, eVar.f);
                    eVar.f = resourceId3;
                    if (resourceId3 == -1) {
                        eVar.f = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 10:
                    int resourceId4 = typedArrayObtainStyledAttributes.getResourceId(index, eVar.f24g);
                    eVar.f24g = resourceId4;
                    if (resourceId4 == -1) {
                        eVar.f24g = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 11:
                    int resourceId5 = typedArrayObtainStyledAttributes.getResourceId(index, eVar.f26h);
                    eVar.f26h = resourceId5;
                    if (resourceId5 == -1) {
                        eVar.f26h = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 12:
                    int resourceId6 = typedArrayObtainStyledAttributes.getResourceId(index, eVar.i);
                    eVar.i = resourceId6;
                    if (resourceId6 == -1) {
                        eVar.i = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 13:
                    int resourceId7 = typedArrayObtainStyledAttributes.getResourceId(index, eVar.f29j);
                    eVar.f29j = resourceId7;
                    if (resourceId7 == -1) {
                        eVar.f29j = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 14:
                    int resourceId8 = typedArrayObtainStyledAttributes.getResourceId(index, eVar.f31k);
                    eVar.f31k = resourceId8;
                    if (resourceId8 == -1) {
                        eVar.f31k = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 15:
                    int resourceId9 = typedArrayObtainStyledAttributes.getResourceId(index, eVar.f33l);
                    eVar.f33l = resourceId9;
                    if (resourceId9 == -1) {
                        eVar.f33l = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 16:
                    int resourceId10 = typedArrayObtainStyledAttributes.getResourceId(index, eVar.f34m);
                    eVar.f34m = resourceId10;
                    if (resourceId10 == -1) {
                        eVar.f34m = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 17:
                    int resourceId11 = typedArrayObtainStyledAttributes.getResourceId(index, eVar.f44s);
                    eVar.f44s = resourceId11;
                    if (resourceId11 == -1) {
                        eVar.f44s = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 18:
                    int resourceId12 = typedArrayObtainStyledAttributes.getResourceId(index, eVar.f45t);
                    eVar.f45t = resourceId12;
                    if (resourceId12 == -1) {
                        eVar.f45t = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 19:
                    int resourceId13 = typedArrayObtainStyledAttributes.getResourceId(index, eVar.f46u);
                    eVar.f46u = resourceId13;
                    if (resourceId13 == -1) {
                        eVar.f46u = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 20:
                    int resourceId14 = typedArrayObtainStyledAttributes.getResourceId(index, eVar.f47v);
                    eVar.f47v = resourceId14;
                    if (resourceId14 == -1) {
                        eVar.f47v = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 21:
                    eVar.f48w = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, eVar.f48w);
                    break;
                case 22:
                    eVar.f49x = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, eVar.f49x);
                    break;
                case 23:
                    eVar.f50y = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, eVar.f50y);
                    break;
                case 24:
                    eVar.f51z = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, eVar.f51z);
                    break;
                case 25:
                    eVar.A = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, eVar.A);
                    break;
                case 26:
                    eVar.B = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, eVar.B);
                    break;
                case 27:
                    eVar.W = typedArrayObtainStyledAttributes.getBoolean(index, eVar.W);
                    break;
                case 28:
                    eVar.X = typedArrayObtainStyledAttributes.getBoolean(index, eVar.X);
                    break;
                case 29:
                    eVar.E = typedArrayObtainStyledAttributes.getFloat(index, eVar.E);
                    break;
                case 30:
                    eVar.F = typedArrayObtainStyledAttributes.getFloat(index, eVar.F);
                    break;
                case 31:
                    int i11 = typedArrayObtainStyledAttributes.getInt(index, 0);
                    eVar.L = i11;
                    if (i11 == 1) {
                        Log.e("ConstraintLayout", "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                    }
                    break;
                case 32:
                    int i12 = typedArrayObtainStyledAttributes.getInt(index, 0);
                    eVar.M = i12;
                    if (i12 == 1) {
                        Log.e("ConstraintLayout", "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                    }
                    break;
                case 33:
                    try {
                        eVar.N = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, eVar.N);
                    } catch (Exception unused) {
                        if (typedArrayObtainStyledAttributes.getInt(index, eVar.N) == -2) {
                            eVar.N = -2;
                        }
                    }
                    break;
                case 34:
                    try {
                        eVar.P = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, eVar.P);
                    } catch (Exception unused2) {
                        if (typedArrayObtainStyledAttributes.getInt(index, eVar.P) == -2) {
                            eVar.P = -2;
                        }
                    }
                    break;
                case 35:
                    eVar.R = Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, eVar.R));
                    eVar.L = 2;
                    break;
                case 36:
                    try {
                        eVar.O = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, eVar.O);
                    } catch (Exception unused3) {
                        if (typedArrayObtainStyledAttributes.getInt(index, eVar.O) == -2) {
                            eVar.O = -2;
                        }
                    }
                    break;
                case 37:
                    try {
                        eVar.Q = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, eVar.Q);
                    } catch (Exception unused4) {
                        if (typedArrayObtainStyledAttributes.getInt(index, eVar.Q) == -2) {
                            eVar.Q = -2;
                        }
                    }
                    break;
                case 38:
                    eVar.S = Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, eVar.S));
                    eVar.M = 2;
                    break;
                default:
                    switch (i10) {
                        case 44:
                            o.h(eVar, typedArrayObtainStyledAttributes.getString(index));
                            break;
                        case 45:
                            eVar.H = typedArrayObtainStyledAttributes.getFloat(index, eVar.H);
                            break;
                        case 46:
                            eVar.I = typedArrayObtainStyledAttributes.getFloat(index, eVar.I);
                            break;
                        case 47:
                            eVar.J = typedArrayObtainStyledAttributes.getInt(index, 0);
                            break;
                        case 48:
                            eVar.K = typedArrayObtainStyledAttributes.getInt(index, 0);
                            break;
                        case 49:
                            eVar.T = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, eVar.T);
                            break;
                        case 50:
                            eVar.U = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, eVar.U);
                            break;
                        case 51:
                            eVar.Y = typedArrayObtainStyledAttributes.getString(index);
                            break;
                        case 52:
                            int resourceId15 = typedArrayObtainStyledAttributes.getResourceId(index, eVar.f36n);
                            eVar.f36n = resourceId15;
                            if (resourceId15 == -1) {
                                eVar.f36n = typedArrayObtainStyledAttributes.getInt(index, -1);
                            }
                            break;
                        case 53:
                            int resourceId16 = typedArrayObtainStyledAttributes.getResourceId(index, eVar.f38o);
                            eVar.f38o = resourceId16;
                            if (resourceId16 == -1) {
                                eVar.f38o = typedArrayObtainStyledAttributes.getInt(index, -1);
                            }
                            break;
                        case 54:
                            eVar.D = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, eVar.D);
                            break;
                        case 55:
                            eVar.C = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, eVar.C);
                            break;
                        default:
                            switch (i10) {
                                case 64:
                                    o.g(eVar, typedArrayObtainStyledAttributes, index, 0);
                                    break;
                                case 65:
                                    o.g(eVar, typedArrayObtainStyledAttributes, index, 1);
                                    break;
                                case 66:
                                    eVar.Z = typedArrayObtainStyledAttributes.getInt(index, eVar.Z);
                                    break;
                                case 67:
                                    eVar.f19d = typedArrayObtainStyledAttributes.getBoolean(index, eVar.f19d);
                                    break;
                            }
                            break;
                    }
                    break;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        eVar.a();
        return eVar;
    }

    public int getMaxHeight() {
        return this.A;
    }

    public int getMaxWidth() {
        return this.f966z;
    }

    public int getMinHeight() {
        return this.f965y;
    }

    public int getMinWidth() {
        return this.f964x;
    }

    public int getOptimizationLevel() {
        return this.f963w.D0;
    }

    public String getSceneString() {
        int id2;
        StringBuilder sb2 = new StringBuilder();
        x.f fVar = this.f963w;
        if (fVar.f14137j == null) {
            int id3 = getId();
            if (id3 != -1) {
                fVar.f14137j = getContext().getResources().getResourceEntryName(id3);
            } else {
                fVar.f14137j = "parent";
            }
        }
        if (fVar.f14135h0 == null) {
            fVar.f14135h0 = fVar.f14137j;
            Log.v("ConstraintLayout", " setDebugName " + fVar.f14135h0);
        }
        ArrayList arrayList = fVar.f14160q0;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            x.e eVar = (x.e) obj;
            View view = eVar.f14131f0;
            if (view != null) {
                if (eVar.f14137j == null && (id2 = view.getId()) != -1) {
                    eVar.f14137j = getContext().getResources().getResourceEntryName(id2);
                }
                if (eVar.f14135h0 == null) {
                    eVar.f14135h0 = eVar.f14137j;
                    Log.v("ConstraintLayout", " setDebugName " + eVar.f14135h0);
                }
            }
        }
        fVar.n(sb2);
        return sb2.toString();
    }

    public final x.e h(View view) {
        if (view == this) {
            return this.f963w;
        }
        if (view == null) {
            return null;
        }
        if (view.getLayoutParams() instanceof e) {
            return ((e) view.getLayoutParams()).f41p0;
        }
        view.setLayoutParams(generateLayoutParams(view.getLayoutParams()));
        if (view.getLayoutParams() instanceof e) {
            return ((e) view.getLayoutParams()).f41p0;
        }
        return null;
    }

    public final void i(AttributeSet attributeSet, int i) {
        x.f fVar = this.f963w;
        fVar.f14131f0 = this;
        f fVar2 = this.I;
        fVar.f14164u0 = fVar2;
        fVar.f14162s0.f = fVar2;
        this.f961u.put(getId(), this);
        this.D = null;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, s.ConstraintLayout_Layout, i, 0);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == s.ConstraintLayout_Layout_android_minWidth) {
                    this.f964x = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f964x);
                } else if (index == s.ConstraintLayout_Layout_android_minHeight) {
                    this.f965y = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f965y);
                } else if (index == s.ConstraintLayout_Layout_android_maxWidth) {
                    this.f966z = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f966z);
                } else if (index == s.ConstraintLayout_Layout_android_maxHeight) {
                    this.A = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.A);
                } else if (index == s.ConstraintLayout_Layout_layout_optimizationLevel) {
                    this.C = typedArrayObtainStyledAttributes.getInt(index, this.C);
                } else if (index == s.ConstraintLayout_Layout_layoutDescription) {
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            j(resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.E = null;
                        }
                    }
                } else if (index == s.ConstraintLayout_Layout_constraintSet) {
                    int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    try {
                        o oVar = new o();
                        this.D = oVar;
                        oVar.e(getContext(), resourceId2);
                    } catch (Resources.NotFoundException unused2) {
                        this.D = null;
                    }
                    this.F = resourceId2;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        fVar.D0 = this.C;
        v.c.f13087p = fVar.W(512);
    }

    public final void j(int i) {
        String str;
        Context context = getContext();
        k4 k4Var = new k4();
        k4Var.f3070u = new SparseArray();
        k4Var.f3071v = new SparseArray();
        XmlResourceParser xml = context.getResources().getXml(i);
        try {
            g gVar = null;
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    switch (name.hashCode()) {
                        case -1349929691:
                            if (name.equals("ConstraintSet")) {
                                k4Var.x(context, xml);
                            }
                            break;
                        case 80204913:
                            if (name.equals("State")) {
                                gVar = new g(context, xml);
                                ((SparseArray) k4Var.f3070u).put(gVar.f59u, gVar);
                            }
                            break;
                        case 1382829617:
                            str = "StateSet";
                            name.equals(str);
                            break;
                        case 1657696882:
                            str = "layoutDescription";
                            name.equals(str);
                            break;
                        case 1901439077:
                            if (name.equals("Variant")) {
                                h hVar = new h(context, xml);
                                if (gVar != null) {
                                    ((ArrayList) gVar.f61w).add(hVar);
                                }
                            }
                            break;
                    }
                }
            }
        } catch (IOException e10) {
            e10.printStackTrace();
        } catch (XmlPullParserException e11) {
            e11.printStackTrace();
        }
        this.E = k4Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:160:0x030c  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x032d  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x034c  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0368  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k(x.f r29, int r30, int r31, int r32) {
        /*
            Method dump skipped, instruction units count: 1762
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.k(x.f, int, int, int):void");
    }

    public final void l(x.e eVar, e eVar2, SparseArray sparseArray, int i, int i10) {
        View view = (View) this.f961u.get(i);
        x.e eVar3 = (x.e) sparseArray.get(i);
        if (eVar3 == null || view == null || !(view.getLayoutParams() instanceof e)) {
            return;
        }
        eVar2.f18c0 = true;
        if (i10 == 6) {
            e eVar4 = (e) view.getLayoutParams();
            eVar4.f18c0 = true;
            eVar4.f41p0.E = true;
        }
        eVar.i(6).b(eVar3.i(i10), eVar2.D, eVar2.C, true);
        eVar.E = true;
        eVar.i(3).j();
        eVar.i(5).j();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i, int i10, int i11, int i12) {
        int childCount = getChildCount();
        boolean zIsInEditMode = isInEditMode();
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            e eVar = (e) childAt.getLayoutParams();
            x.e eVar2 = eVar.f41p0;
            if (childAt.getVisibility() != 8 || eVar.f20d0 || eVar.f22e0 || zIsInEditMode) {
                int iR = eVar2.r();
                int iS = eVar2.s();
                childAt.layout(iR, iS, eVar2.q() + iR, eVar2.k() + iS);
            }
        }
        ArrayList arrayList = this.f962v;
        int size = arrayList.size();
        if (size > 0) {
            for (int i14 = 0; i14 < size; i14++) {
                ((c) arrayList.get(i14)).getClass();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0343  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x035b  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0379  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x039b  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x03c6  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x03e3  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0405  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0410  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x042e  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0436  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x055b  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x0561  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r35, int r36) {
        /*
            Method dump skipped, instruction units count: 1569
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup
    public final void onViewAdded(View view) {
        super.onViewAdded(view);
        x.e eVarH = h(view);
        if ((view instanceof q) && !(eVarH instanceof i)) {
            e eVar = (e) view.getLayoutParams();
            i iVar = new i();
            eVar.f41p0 = iVar;
            eVar.f20d0 = true;
            iVar.S(eVar.V);
        }
        if (view instanceof c) {
            c cVar = (c) view;
            cVar.i();
            ((e) view.getLayoutParams()).f22e0 = true;
            ArrayList arrayList = this.f962v;
            if (!arrayList.contains(cVar)) {
                arrayList.add(cVar);
            }
        }
        this.f961u.put(view.getId(), view);
        this.B = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.f961u.remove(view.getId());
        x.e eVarH = h(view);
        this.f963w.f14160q0.remove(eVarH);
        eVarH.C();
        this.f962v.remove(view);
        this.B = true;
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        this.B = true;
        super.requestLayout();
    }

    public void setConstraintSet(o oVar) {
        this.D = oVar;
    }

    @Override // android.view.View
    public void setId(int i) {
        int id2 = getId();
        SparseArray sparseArray = this.f961u;
        sparseArray.remove(id2);
        super.setId(i);
        sparseArray.put(getId(), this);
    }

    public void setMaxHeight(int i) {
        if (i == this.A) {
            return;
        }
        this.A = i;
        requestLayout();
    }

    public void setMaxWidth(int i) {
        if (i == this.f966z) {
            return;
        }
        this.f966z = i;
        requestLayout();
    }

    public void setMinHeight(int i) {
        if (i == this.f965y) {
            return;
        }
        this.f965y = i;
        requestLayout();
    }

    public void setMinWidth(int i) {
        if (i == this.f964x) {
            return;
        }
        this.f964x = i;
        requestLayout();
    }

    public void setOnConstraintsChanged(p pVar) {
        k4 k4Var = this.E;
        if (k4Var != null) {
            k4Var.getClass();
        }
    }

    public void setOptimizationLevel(int i) {
        this.C = i;
        x.f fVar = this.f963w;
        fVar.D0 = i;
        v.c.f13087p = fVar.W(512);
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f961u = new SparseArray();
        this.f962v = new ArrayList(4);
        this.f963w = new x.f();
        this.f964x = 0;
        this.f965y = 0;
        this.f966z = Integer.MAX_VALUE;
        this.A = Integer.MAX_VALUE;
        this.B = true;
        this.C = 257;
        this.D = null;
        this.E = null;
        this.F = -1;
        this.G = new HashMap();
        this.H = new SparseArray();
        this.I = new f(this, this);
        this.J = 0;
        this.K = 0;
        i(attributeSet, i);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        e eVar = new e(layoutParams);
        eVar.f13a = -1;
        eVar.f15b = -1;
        eVar.f17c = -1.0f;
        eVar.f19d = true;
        eVar.f21e = -1;
        eVar.f = -1;
        eVar.f24g = -1;
        eVar.f26h = -1;
        eVar.i = -1;
        eVar.f29j = -1;
        eVar.f31k = -1;
        eVar.f33l = -1;
        eVar.f34m = -1;
        eVar.f36n = -1;
        eVar.f38o = -1;
        eVar.f40p = -1;
        eVar.f42q = 0;
        eVar.f43r = 0.0f;
        eVar.f44s = -1;
        eVar.f45t = -1;
        eVar.f46u = -1;
        eVar.f47v = -1;
        eVar.f48w = Integer.MIN_VALUE;
        eVar.f49x = Integer.MIN_VALUE;
        eVar.f50y = Integer.MIN_VALUE;
        eVar.f51z = Integer.MIN_VALUE;
        eVar.A = Integer.MIN_VALUE;
        eVar.B = Integer.MIN_VALUE;
        eVar.C = Integer.MIN_VALUE;
        eVar.D = 0;
        eVar.E = 0.5f;
        eVar.F = 0.5f;
        eVar.G = null;
        eVar.H = -1.0f;
        eVar.I = -1.0f;
        eVar.J = 0;
        eVar.K = 0;
        eVar.L = 0;
        eVar.M = 0;
        eVar.N = 0;
        eVar.O = 0;
        eVar.P = 0;
        eVar.Q = 0;
        eVar.R = 1.0f;
        eVar.S = 1.0f;
        eVar.T = -1;
        eVar.U = -1;
        eVar.V = -1;
        eVar.W = false;
        eVar.X = false;
        eVar.Y = null;
        eVar.Z = 0;
        eVar.f14a0 = true;
        eVar.f16b0 = true;
        eVar.f18c0 = false;
        eVar.f20d0 = false;
        eVar.f22e0 = false;
        eVar.f23f0 = -1;
        eVar.f25g0 = -1;
        eVar.f27h0 = -1;
        eVar.f28i0 = -1;
        eVar.f30j0 = Integer.MIN_VALUE;
        eVar.f32k0 = Integer.MIN_VALUE;
        eVar.l0 = 0.5f;
        eVar.f41p0 = new x.e();
        return eVar;
    }
}
