package androidx.constraintlayout.widget;

import a0.d;
import a0.e;
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
import b2.q;
import d0.c;
import d0.f;
import d0.g;
import d0.n;
import d0.o;
import d0.p;
import d0.r;
import d0.s;
import g1.h;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import l4.c0;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class ConstraintLayout extends ViewGroup {
    public static s K;
    public int A;
    public int B;
    public boolean C;
    public int D;
    public n E;
    public c0 F;
    public int G;
    public HashMap H;
    public final SparseArray I;
    public final f J;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final SparseArray f638v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ArrayList f639w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final e f640x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f641y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f642z;

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f638v = new SparseArray();
        this.f639w = new ArrayList(4);
        this.f640x = new e();
        this.f641y = 0;
        this.f642z = 0;
        this.A = Integer.MAX_VALUE;
        this.B = Integer.MAX_VALUE;
        this.C = true;
        this.D = 257;
        this.E = null;
        this.F = null;
        this.G = -1;
        this.H = new HashMap();
        this.I = new SparseArray();
        this.J = new f(this, this);
        i(attributeSet, 0);
    }

    public static d0.e g() {
        d0.e eVar = new d0.e(-2, -2);
        eVar.f3069a = -1;
        eVar.f3071b = -1;
        eVar.f3073c = -1.0f;
        eVar.f3075d = true;
        eVar.f3077e = -1;
        eVar.f = -1;
        eVar.f3080g = -1;
        eVar.f3082h = -1;
        eVar.i = -1;
        eVar.f3085j = -1;
        eVar.f3087k = -1;
        eVar.f3089l = -1;
        eVar.f3091m = -1;
        eVar.f3093n = -1;
        eVar.f3095o = -1;
        eVar.f3096p = -1;
        eVar.f3098q = 0;
        eVar.f3099r = 0.0f;
        eVar.f3100s = -1;
        eVar.f3101t = -1;
        eVar.f3102u = -1;
        eVar.f3103v = -1;
        eVar.f3104w = Integer.MIN_VALUE;
        eVar.f3105x = Integer.MIN_VALUE;
        eVar.f3106y = Integer.MIN_VALUE;
        eVar.f3107z = Integer.MIN_VALUE;
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
        eVar.f3070a0 = true;
        eVar.f3072b0 = true;
        eVar.f3074c0 = false;
        eVar.f3076d0 = false;
        eVar.f3078e0 = false;
        eVar.f3079f0 = -1;
        eVar.f3081g0 = -1;
        eVar.f3083h0 = -1;
        eVar.f3084i0 = -1;
        eVar.f3086j0 = Integer.MIN_VALUE;
        eVar.f3088k0 = Integer.MIN_VALUE;
        eVar.f3090l0 = 0.5f;
        eVar.f3097p0 = new d();
        return eVar;
    }

    private int getPaddingWidth() {
        int iMax = Math.max(0, getPaddingRight()) + Math.max(0, getPaddingLeft());
        int iMax2 = Math.max(0, getPaddingEnd()) + Math.max(0, getPaddingStart());
        return iMax2 > 0 ? iMax2 : iMax;
    }

    public static s getSharedValues() {
        if (K == null) {
            s sVar = new s();
            new SparseIntArray();
            new HashMap();
            K = sVar;
        }
        return K;
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof d0.e;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        Object tag;
        int size;
        ArrayList arrayList = this.f639w;
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
                        float f10 = i15;
                        float f11 = i14 + ((int) ((i13 / 1080.0f) * width));
                        canvas.drawLine(f, f10, f11, f10, paint);
                        float f12 = i15 + ((int) ((Integer.parseInt(strArrSplit[3]) / 1920.0f) * height));
                        canvas.drawLine(f11, f10, f11, f12, paint);
                        canvas.drawLine(f11, f12, f, f12, paint);
                        canvas.drawLine(f, f12, f, f10, paint);
                        paint.setColor(-16711936);
                        canvas.drawLine(f, f10, f11, f12, paint);
                        canvas.drawLine(f, f12, f11, f10, paint);
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public final void forceLayout() {
        this.C = true;
        super.forceLayout();
    }

    @Override // android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return g();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        d0.e eVar = new d0.e(context, attributeSet);
        eVar.f3069a = -1;
        eVar.f3071b = -1;
        eVar.f3073c = -1.0f;
        eVar.f3075d = true;
        eVar.f3077e = -1;
        eVar.f = -1;
        eVar.f3080g = -1;
        eVar.f3082h = -1;
        eVar.i = -1;
        eVar.f3085j = -1;
        eVar.f3087k = -1;
        eVar.f3089l = -1;
        eVar.f3091m = -1;
        eVar.f3093n = -1;
        eVar.f3095o = -1;
        eVar.f3096p = -1;
        eVar.f3098q = 0;
        eVar.f3099r = 0.0f;
        eVar.f3100s = -1;
        eVar.f3101t = -1;
        eVar.f3102u = -1;
        eVar.f3103v = -1;
        eVar.f3104w = Integer.MIN_VALUE;
        eVar.f3105x = Integer.MIN_VALUE;
        eVar.f3106y = Integer.MIN_VALUE;
        eVar.f3107z = Integer.MIN_VALUE;
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
        eVar.f3070a0 = true;
        eVar.f3072b0 = true;
        eVar.f3074c0 = false;
        eVar.f3076d0 = false;
        eVar.f3078e0 = false;
        eVar.f3079f0 = -1;
        eVar.f3081g0 = -1;
        eVar.f3083h0 = -1;
        eVar.f3084i0 = -1;
        eVar.f3086j0 = Integer.MIN_VALUE;
        eVar.f3088k0 = Integer.MIN_VALUE;
        eVar.f3090l0 = 0.5f;
        eVar.f3097p0 = new d();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, r.ConstraintLayout_Layout);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i);
            int i10 = d0.d.f3068a.get(index);
            switch (i10) {
                case 1:
                    eVar.V = typedArrayObtainStyledAttributes.getInt(index, eVar.V);
                    break;
                case 2:
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, eVar.f3096p);
                    eVar.f3096p = resourceId;
                    if (resourceId == -1) {
                        eVar.f3096p = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 3:
                    eVar.f3098q = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, eVar.f3098q);
                    break;
                case h.LONG_FIELD_NUMBER /* 4 */:
                    float f = typedArrayObtainStyledAttributes.getFloat(index, eVar.f3099r) % 360.0f;
                    eVar.f3099r = f;
                    if (f < 0.0f) {
                        eVar.f3099r = (360.0f - f) % 360.0f;
                    }
                    break;
                case h.STRING_FIELD_NUMBER /* 5 */:
                    eVar.f3069a = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, eVar.f3069a);
                    break;
                case h.STRING_SET_FIELD_NUMBER /* 6 */:
                    eVar.f3071b = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, eVar.f3071b);
                    break;
                case h.DOUBLE_FIELD_NUMBER /* 7 */:
                    eVar.f3073c = typedArrayObtainStyledAttributes.getFloat(index, eVar.f3073c);
                    break;
                case h.BYTES_FIELD_NUMBER /* 8 */:
                    int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, eVar.f3077e);
                    eVar.f3077e = resourceId2;
                    if (resourceId2 == -1) {
                        eVar.f3077e = typedArrayObtainStyledAttributes.getInt(index, -1);
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
                    int resourceId4 = typedArrayObtainStyledAttributes.getResourceId(index, eVar.f3080g);
                    eVar.f3080g = resourceId4;
                    if (resourceId4 == -1) {
                        eVar.f3080g = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 11:
                    int resourceId5 = typedArrayObtainStyledAttributes.getResourceId(index, eVar.f3082h);
                    eVar.f3082h = resourceId5;
                    if (resourceId5 == -1) {
                        eVar.f3082h = typedArrayObtainStyledAttributes.getInt(index, -1);
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
                    int resourceId7 = typedArrayObtainStyledAttributes.getResourceId(index, eVar.f3085j);
                    eVar.f3085j = resourceId7;
                    if (resourceId7 == -1) {
                        eVar.f3085j = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 14:
                    int resourceId8 = typedArrayObtainStyledAttributes.getResourceId(index, eVar.f3087k);
                    eVar.f3087k = resourceId8;
                    if (resourceId8 == -1) {
                        eVar.f3087k = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 15:
                    int resourceId9 = typedArrayObtainStyledAttributes.getResourceId(index, eVar.f3089l);
                    eVar.f3089l = resourceId9;
                    if (resourceId9 == -1) {
                        eVar.f3089l = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 16:
                    int resourceId10 = typedArrayObtainStyledAttributes.getResourceId(index, eVar.f3091m);
                    eVar.f3091m = resourceId10;
                    if (resourceId10 == -1) {
                        eVar.f3091m = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 17:
                    int resourceId11 = typedArrayObtainStyledAttributes.getResourceId(index, eVar.f3100s);
                    eVar.f3100s = resourceId11;
                    if (resourceId11 == -1) {
                        eVar.f3100s = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 18:
                    int resourceId12 = typedArrayObtainStyledAttributes.getResourceId(index, eVar.f3101t);
                    eVar.f3101t = resourceId12;
                    if (resourceId12 == -1) {
                        eVar.f3101t = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 19:
                    int resourceId13 = typedArrayObtainStyledAttributes.getResourceId(index, eVar.f3102u);
                    eVar.f3102u = resourceId13;
                    if (resourceId13 == -1) {
                        eVar.f3102u = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 20:
                    int resourceId14 = typedArrayObtainStyledAttributes.getResourceId(index, eVar.f3103v);
                    eVar.f3103v = resourceId14;
                    if (resourceId14 == -1) {
                        eVar.f3103v = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 21:
                    eVar.f3104w = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, eVar.f3104w);
                    break;
                case 22:
                    eVar.f3105x = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, eVar.f3105x);
                    break;
                case 23:
                    eVar.f3106y = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, eVar.f3106y);
                    break;
                case 24:
                    eVar.f3107z = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, eVar.f3107z);
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
                            n.h(eVar, typedArrayObtainStyledAttributes.getString(index));
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
                            int resourceId15 = typedArrayObtainStyledAttributes.getResourceId(index, eVar.f3093n);
                            eVar.f3093n = resourceId15;
                            if (resourceId15 == -1) {
                                eVar.f3093n = typedArrayObtainStyledAttributes.getInt(index, -1);
                            }
                            break;
                        case 53:
                            int resourceId16 = typedArrayObtainStyledAttributes.getResourceId(index, eVar.f3095o);
                            eVar.f3095o = resourceId16;
                            if (resourceId16 == -1) {
                                eVar.f3095o = typedArrayObtainStyledAttributes.getInt(index, -1);
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
                                    n.g(eVar, typedArrayObtainStyledAttributes, index, 0);
                                    break;
                                case 65:
                                    n.g(eVar, typedArrayObtainStyledAttributes, index, 1);
                                    break;
                                case 66:
                                    eVar.Z = typedArrayObtainStyledAttributes.getInt(index, eVar.Z);
                                    break;
                                case 67:
                                    eVar.f3075d = typedArrayObtainStyledAttributes.getBoolean(index, eVar.f3075d);
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
        return this.B;
    }

    public int getMaxWidth() {
        return this.A;
    }

    public int getMinHeight() {
        return this.f642z;
    }

    public int getMinWidth() {
        return this.f641y;
    }

    public int getOptimizationLevel() {
        return this.f640x.D0;
    }

    public String getSceneString() {
        int id2;
        StringBuilder sb = new StringBuilder();
        e eVar = this.f640x;
        if (eVar.f42j == null) {
            int id3 = getId();
            if (id3 != -1) {
                eVar.f42j = getContext().getResources().getResourceEntryName(id3);
            } else {
                eVar.f42j = "parent";
            }
        }
        if (eVar.f40h0 == null) {
            eVar.f40h0 = eVar.f42j;
            Log.v("ConstraintLayout", " setDebugName " + eVar.f40h0);
        }
        ArrayList arrayList = eVar.f65q0;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            d dVar = (d) obj;
            View view = dVar.f36f0;
            if (view != null) {
                if (dVar.f42j == null && (id2 = view.getId()) != -1) {
                    dVar.f42j = getContext().getResources().getResourceEntryName(id2);
                }
                if (dVar.f40h0 == null) {
                    dVar.f40h0 = dVar.f42j;
                    Log.v("ConstraintLayout", " setDebugName " + dVar.f40h0);
                }
            }
        }
        eVar.n(sb);
        return sb.toString();
    }

    public final d h(View view) {
        if (view == this) {
            return this.f640x;
        }
        if (view == null) {
            return null;
        }
        if (view.getLayoutParams() instanceof d0.e) {
            return ((d0.e) view.getLayoutParams()).f3097p0;
        }
        view.setLayoutParams(generateLayoutParams(view.getLayoutParams()));
        if (view.getLayoutParams() instanceof d0.e) {
            return ((d0.e) view.getLayoutParams()).f3097p0;
        }
        return null;
    }

    public final void i(AttributeSet attributeSet, int i) {
        e eVar = this.f640x;
        eVar.f36f0 = this;
        f fVar = this.J;
        eVar.f69u0 = fVar;
        eVar.f67s0.f1600g = fVar;
        this.f638v.put(getId(), this);
        this.E = null;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, r.ConstraintLayout_Layout, i, 0);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == r.ConstraintLayout_Layout_android_minWidth) {
                    this.f641y = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f641y);
                } else if (index == r.ConstraintLayout_Layout_android_minHeight) {
                    this.f642z = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f642z);
                } else if (index == r.ConstraintLayout_Layout_android_maxWidth) {
                    this.A = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.A);
                } else if (index == r.ConstraintLayout_Layout_android_maxHeight) {
                    this.B = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.B);
                } else if (index == r.ConstraintLayout_Layout_layout_optimizationLevel) {
                    this.D = typedArrayObtainStyledAttributes.getInt(index, this.D);
                } else if (index == r.ConstraintLayout_Layout_layoutDescription) {
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            j(resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.F = null;
                        }
                    }
                } else if (index == r.ConstraintLayout_Layout_constraintSet) {
                    int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    try {
                        n nVar = new n();
                        this.E = nVar;
                        nVar.e(getContext(), resourceId2);
                    } catch (Resources.NotFoundException unused2) {
                        this.E = null;
                    }
                    this.G = resourceId2;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        eVar.D0 = this.D;
        y.c.f14520q = eVar.W(512);
    }

    public final void j(int i) {
        String str;
        Context context = getContext();
        c0 c0Var = new c0(12, false);
        c0Var.f7705w = new SparseArray();
        c0Var.f7706x = new SparseArray();
        XmlResourceParser xml = context.getResources().getXml(i);
        try {
            q qVar = null;
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 2) {
                    String name = xml.getName();
                    switch (name.hashCode()) {
                        case -1349929691:
                            if (name.equals("ConstraintSet")) {
                                c0Var.R(context, xml);
                            }
                            break;
                        case 80204913:
                            if (name.equals("State")) {
                                q qVar2 = new q(context, xml);
                                ((SparseArray) c0Var.f7705w).put(qVar2.f1726v, qVar2);
                                qVar = qVar2;
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
                                g gVar = new g(context, xml);
                                if (qVar != null) {
                                    ((ArrayList) qVar.f1728x).add(gVar);
                                }
                            }
                            break;
                    }
                }
            }
        } catch (IOException e9) {
            Log.e("ConstraintLayoutStates", "Error parsing resource: " + i, e9);
        } catch (XmlPullParserException e10) {
            Log.e("ConstraintLayoutStates", "Error parsing resource: " + i, e10);
        }
        this.F = c0Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:160:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0333  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0352  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x036e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k(a0.e r29, int r30, int r31, int r32) {
        /*
            Method dump skipped, instruction units count: 1772
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.k(a0.e, int, int, int):void");
    }

    public final void l(d dVar, d0.e eVar, SparseArray sparseArray, int i, int i10) {
        View view = (View) this.f638v.get(i);
        d dVar2 = (d) sparseArray.get(i);
        if (dVar2 == null || view == null || !(view.getLayoutParams() instanceof d0.e)) {
            return;
        }
        eVar.f3074c0 = true;
        if (i10 == 6) {
            d0.e eVar2 = (d0.e) view.getLayoutParams();
            eVar2.f3074c0 = true;
            eVar2.f3097p0.E = true;
        }
        dVar.i(6).b(dVar2.i(i10), eVar.D, eVar.C, true);
        dVar.E = true;
        dVar.i(3).j();
        dVar.i(5).j();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i, int i10, int i11, int i12) {
        int childCount = getChildCount();
        boolean zIsInEditMode = isInEditMode();
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            d0.e eVar = (d0.e) childAt.getLayoutParams();
            d dVar = eVar.f3097p0;
            if (childAt.getVisibility() != 8 || eVar.f3076d0 || eVar.f3078e0 || zIsInEditMode) {
                int iR = dVar.r();
                int iS = dVar.s();
                childAt.layout(iR, iS, dVar.q() + iR, dVar.k() + iS);
            }
        }
        ArrayList arrayList = this.f639w;
        int size = arrayList.size();
        if (size > 0) {
            for (int i14 = 0; i14 < size; i14++) {
                ((c) arrayList.get(i14)).getClass();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0353  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0371  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0393  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x03be  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x03db  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x03fd  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0408  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0426  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x042e  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x0553  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x0559  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r35, int r36) {
        /*
            Method dump skipped, instruction units count: 1566
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup
    public final void onViewAdded(View view) {
        super.onViewAdded(view);
        d dVarH = h(view);
        if ((view instanceof p) && !(dVarH instanceof a0.h)) {
            d0.e eVar = (d0.e) view.getLayoutParams();
            a0.h hVar = new a0.h();
            eVar.f3097p0 = hVar;
            eVar.f3076d0 = true;
            hVar.S(eVar.V);
        }
        if (view instanceof c) {
            c cVar = (c) view;
            cVar.i();
            ((d0.e) view.getLayoutParams()).f3078e0 = true;
            ArrayList arrayList = this.f639w;
            if (!arrayList.contains(cVar)) {
                arrayList.add(cVar);
            }
        }
        this.f638v.put(view.getId(), view);
        this.C = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.f638v.remove(view.getId());
        d dVarH = h(view);
        this.f640x.f65q0.remove(dVarH);
        dVarH.C();
        this.f639w.remove(view);
        this.C = true;
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        this.C = true;
        super.requestLayout();
    }

    public void setConstraintSet(n nVar) {
        this.E = nVar;
    }

    @Override // android.view.View
    public void setId(int i) {
        int id2 = getId();
        SparseArray sparseArray = this.f638v;
        sparseArray.remove(id2);
        super.setId(i);
        sparseArray.put(getId(), this);
    }

    public void setMaxHeight(int i) {
        if (i == this.B) {
            return;
        }
        this.B = i;
        requestLayout();
    }

    public void setMaxWidth(int i) {
        if (i == this.A) {
            return;
        }
        this.A = i;
        requestLayout();
    }

    public void setMinHeight(int i) {
        if (i == this.f642z) {
            return;
        }
        this.f642z = i;
        requestLayout();
    }

    public void setMinWidth(int i) {
        if (i == this.f641y) {
            return;
        }
        this.f641y = i;
        requestLayout();
    }

    public void setOnConstraintsChanged(o oVar) {
        c0 c0Var = this.F;
        if (c0Var != null) {
            c0Var.getClass();
        }
    }

    public void setOptimizationLevel(int i) {
        this.D = i;
        e eVar = this.f640x;
        eVar.D0 = i;
        y.c.f14520q = eVar.W(512);
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f638v = new SparseArray();
        this.f639w = new ArrayList(4);
        this.f640x = new e();
        this.f641y = 0;
        this.f642z = 0;
        this.A = Integer.MAX_VALUE;
        this.B = Integer.MAX_VALUE;
        this.C = true;
        this.D = 257;
        this.E = null;
        this.F = null;
        this.G = -1;
        this.H = new HashMap();
        this.I = new SparseArray();
        this.J = new f(this, this);
        i(attributeSet, i);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        d0.e eVar = new d0.e(layoutParams);
        eVar.f3069a = -1;
        eVar.f3071b = -1;
        eVar.f3073c = -1.0f;
        eVar.f3075d = true;
        eVar.f3077e = -1;
        eVar.f = -1;
        eVar.f3080g = -1;
        eVar.f3082h = -1;
        eVar.i = -1;
        eVar.f3085j = -1;
        eVar.f3087k = -1;
        eVar.f3089l = -1;
        eVar.f3091m = -1;
        eVar.f3093n = -1;
        eVar.f3095o = -1;
        eVar.f3096p = -1;
        eVar.f3098q = 0;
        eVar.f3099r = 0.0f;
        eVar.f3100s = -1;
        eVar.f3101t = -1;
        eVar.f3102u = -1;
        eVar.f3103v = -1;
        eVar.f3104w = Integer.MIN_VALUE;
        eVar.f3105x = Integer.MIN_VALUE;
        eVar.f3106y = Integer.MIN_VALUE;
        eVar.f3107z = Integer.MIN_VALUE;
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
        eVar.f3070a0 = true;
        eVar.f3072b0 = true;
        eVar.f3074c0 = false;
        eVar.f3076d0 = false;
        eVar.f3078e0 = false;
        eVar.f3079f0 = -1;
        eVar.f3081g0 = -1;
        eVar.f3083h0 = -1;
        eVar.f3084i0 = -1;
        eVar.f3086j0 = Integer.MIN_VALUE;
        eVar.f3088k0 = Integer.MIN_VALUE;
        eVar.f3090l0 = 0.5f;
        eVar.f3097p0 = new d();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            ((ViewGroup.MarginLayoutParams) eVar).leftMargin = marginLayoutParams.leftMargin;
            ((ViewGroup.MarginLayoutParams) eVar).rightMargin = marginLayoutParams.rightMargin;
            ((ViewGroup.MarginLayoutParams) eVar).topMargin = marginLayoutParams.topMargin;
            ((ViewGroup.MarginLayoutParams) eVar).bottomMargin = marginLayoutParams.bottomMargin;
            eVar.setMarginStart(marginLayoutParams.getMarginStart());
            eVar.setMarginEnd(marginLayoutParams.getMarginEnd());
        }
        if (!(layoutParams instanceof d0.e)) {
            return eVar;
        }
        d0.e eVar2 = (d0.e) layoutParams;
        eVar.f3069a = eVar2.f3069a;
        eVar.f3071b = eVar2.f3071b;
        eVar.f3073c = eVar2.f3073c;
        eVar.f3075d = eVar2.f3075d;
        eVar.f3077e = eVar2.f3077e;
        eVar.f = eVar2.f;
        eVar.f3080g = eVar2.f3080g;
        eVar.f3082h = eVar2.f3082h;
        eVar.i = eVar2.i;
        eVar.f3085j = eVar2.f3085j;
        eVar.f3087k = eVar2.f3087k;
        eVar.f3089l = eVar2.f3089l;
        eVar.f3091m = eVar2.f3091m;
        eVar.f3093n = eVar2.f3093n;
        eVar.f3095o = eVar2.f3095o;
        eVar.f3096p = eVar2.f3096p;
        eVar.f3098q = eVar2.f3098q;
        eVar.f3099r = eVar2.f3099r;
        eVar.f3100s = eVar2.f3100s;
        eVar.f3101t = eVar2.f3101t;
        eVar.f3102u = eVar2.f3102u;
        eVar.f3103v = eVar2.f3103v;
        eVar.f3104w = eVar2.f3104w;
        eVar.f3105x = eVar2.f3105x;
        eVar.f3106y = eVar2.f3106y;
        eVar.f3107z = eVar2.f3107z;
        eVar.A = eVar2.A;
        eVar.B = eVar2.B;
        eVar.C = eVar2.C;
        eVar.D = eVar2.D;
        eVar.E = eVar2.E;
        eVar.F = eVar2.F;
        eVar.G = eVar2.G;
        eVar.H = eVar2.H;
        eVar.I = eVar2.I;
        eVar.J = eVar2.J;
        eVar.K = eVar2.K;
        eVar.W = eVar2.W;
        eVar.X = eVar2.X;
        eVar.L = eVar2.L;
        eVar.M = eVar2.M;
        eVar.N = eVar2.N;
        eVar.P = eVar2.P;
        eVar.O = eVar2.O;
        eVar.Q = eVar2.Q;
        eVar.R = eVar2.R;
        eVar.S = eVar2.S;
        eVar.T = eVar2.T;
        eVar.U = eVar2.U;
        eVar.V = eVar2.V;
        eVar.f3070a0 = eVar2.f3070a0;
        eVar.f3072b0 = eVar2.f3072b0;
        eVar.f3074c0 = eVar2.f3074c0;
        eVar.f3076d0 = eVar2.f3076d0;
        eVar.f3079f0 = eVar2.f3079f0;
        eVar.f3081g0 = eVar2.f3081g0;
        eVar.f3083h0 = eVar2.f3083h0;
        eVar.f3084i0 = eVar2.f3084i0;
        eVar.f3086j0 = eVar2.f3086j0;
        eVar.f3088k0 = eVar2.f3088k0;
        eVar.f3090l0 = eVar2.f3090l0;
        eVar.Y = eVar2.Y;
        eVar.Z = eVar2.Z;
        eVar.f3097p0 = eVar2.f3097p0;
        return eVar;
    }
}
