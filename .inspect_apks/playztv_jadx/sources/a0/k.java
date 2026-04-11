package a0;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public static final SparseIntArray f82p0;
    public int A;
    public float B;
    public int C;
    public int D;
    public int E;
    public int F;
    public int G;
    public int H;
    public int I;
    public int J;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public int S;
    public float T;
    public float U;
    public int V;
    public int W;
    public int X;
    public int Y;
    public int Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f83a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public int f84a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f85b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public int f86b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f87c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public int f88c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f89d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public float f90d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f91e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public float f92e0;
    public float f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public int f93f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f94g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public int f95g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f96h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public int f97h0;
    public int i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public int[] f98i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f99j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public String f100j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f101k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public String f102k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f103l;
    public boolean l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f104m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public boolean f105m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f106n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public boolean f107n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f108o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public int f109o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f110p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f111q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f112r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f113s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f114t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f115u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f116v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f117w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f118x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f119y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f120z;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f82p0 = sparseIntArray;
        sparseIntArray.append(s.Layout_layout_constraintLeft_toLeftOf, 24);
        sparseIntArray.append(s.Layout_layout_constraintLeft_toRightOf, 25);
        sparseIntArray.append(s.Layout_layout_constraintRight_toLeftOf, 28);
        sparseIntArray.append(s.Layout_layout_constraintRight_toRightOf, 29);
        sparseIntArray.append(s.Layout_layout_constraintTop_toTopOf, 35);
        sparseIntArray.append(s.Layout_layout_constraintTop_toBottomOf, 34);
        sparseIntArray.append(s.Layout_layout_constraintBottom_toTopOf, 4);
        sparseIntArray.append(s.Layout_layout_constraintBottom_toBottomOf, 3);
        sparseIntArray.append(s.Layout_layout_constraintBaseline_toBaselineOf, 1);
        sparseIntArray.append(s.Layout_layout_editor_absoluteX, 6);
        sparseIntArray.append(s.Layout_layout_editor_absoluteY, 7);
        sparseIntArray.append(s.Layout_layout_constraintGuide_begin, 17);
        sparseIntArray.append(s.Layout_layout_constraintGuide_end, 18);
        sparseIntArray.append(s.Layout_layout_constraintGuide_percent, 19);
        sparseIntArray.append(s.Layout_guidelineUseRtl, 90);
        sparseIntArray.append(s.Layout_android_orientation, 26);
        sparseIntArray.append(s.Layout_layout_constraintStart_toEndOf, 31);
        sparseIntArray.append(s.Layout_layout_constraintStart_toStartOf, 32);
        sparseIntArray.append(s.Layout_layout_constraintEnd_toStartOf, 10);
        sparseIntArray.append(s.Layout_layout_constraintEnd_toEndOf, 9);
        sparseIntArray.append(s.Layout_layout_goneMarginLeft, 13);
        sparseIntArray.append(s.Layout_layout_goneMarginTop, 16);
        sparseIntArray.append(s.Layout_layout_goneMarginRight, 14);
        sparseIntArray.append(s.Layout_layout_goneMarginBottom, 11);
        sparseIntArray.append(s.Layout_layout_goneMarginStart, 15);
        sparseIntArray.append(s.Layout_layout_goneMarginEnd, 12);
        sparseIntArray.append(s.Layout_layout_constraintVertical_weight, 38);
        sparseIntArray.append(s.Layout_layout_constraintHorizontal_weight, 37);
        sparseIntArray.append(s.Layout_layout_constraintHorizontal_chainStyle, 39);
        sparseIntArray.append(s.Layout_layout_constraintVertical_chainStyle, 40);
        sparseIntArray.append(s.Layout_layout_constraintHorizontal_bias, 20);
        sparseIntArray.append(s.Layout_layout_constraintVertical_bias, 36);
        sparseIntArray.append(s.Layout_layout_constraintDimensionRatio, 5);
        sparseIntArray.append(s.Layout_layout_constraintLeft_creator, 91);
        sparseIntArray.append(s.Layout_layout_constraintTop_creator, 91);
        sparseIntArray.append(s.Layout_layout_constraintRight_creator, 91);
        sparseIntArray.append(s.Layout_layout_constraintBottom_creator, 91);
        sparseIntArray.append(s.Layout_layout_constraintBaseline_creator, 91);
        sparseIntArray.append(s.Layout_android_layout_marginLeft, 23);
        sparseIntArray.append(s.Layout_android_layout_marginRight, 27);
        sparseIntArray.append(s.Layout_android_layout_marginStart, 30);
        sparseIntArray.append(s.Layout_android_layout_marginEnd, 8);
        sparseIntArray.append(s.Layout_android_layout_marginTop, 33);
        sparseIntArray.append(s.Layout_android_layout_marginBottom, 2);
        sparseIntArray.append(s.Layout_android_layout_width, 22);
        sparseIntArray.append(s.Layout_android_layout_height, 21);
        sparseIntArray.append(s.Layout_layout_constraintWidth, 41);
        sparseIntArray.append(s.Layout_layout_constraintHeight, 42);
        sparseIntArray.append(s.Layout_layout_constrainedWidth, 41);
        sparseIntArray.append(s.Layout_layout_constrainedHeight, 42);
        sparseIntArray.append(s.Layout_layout_wrapBehaviorInParent, 76);
        sparseIntArray.append(s.Layout_layout_constraintCircle, 61);
        sparseIntArray.append(s.Layout_layout_constraintCircleRadius, 62);
        sparseIntArray.append(s.Layout_layout_constraintCircleAngle, 63);
        sparseIntArray.append(s.Layout_layout_constraintWidth_percent, 69);
        sparseIntArray.append(s.Layout_layout_constraintHeight_percent, 70);
        sparseIntArray.append(s.Layout_chainUseRtl, 71);
        sparseIntArray.append(s.Layout_barrierDirection, 72);
        sparseIntArray.append(s.Layout_barrierMargin, 73);
        sparseIntArray.append(s.Layout_constraint_referenced_ids, 74);
        sparseIntArray.append(s.Layout_barrierAllowsGoneWidgets, 75);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, s.Layout);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i);
            SparseIntArray sparseIntArray = f82p0;
            int i10 = sparseIntArray.get(index);
            switch (i10) {
                case 1:
                    this.f110p = o.f(typedArrayObtainStyledAttributes, index, this.f110p);
                    break;
                case 2:
                    this.I = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.I);
                    break;
                case 3:
                    this.f108o = o.f(typedArrayObtainStyledAttributes, index, this.f108o);
                    break;
                case b1.j.LONG_FIELD_NUMBER /* 4 */:
                    this.f106n = o.f(typedArrayObtainStyledAttributes, index, this.f106n);
                    break;
                case b1.j.STRING_FIELD_NUMBER /* 5 */:
                    this.f119y = typedArrayObtainStyledAttributes.getString(index);
                    break;
                case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                    this.C = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.C);
                    break;
                case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                    this.D = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.D);
                    break;
                case 8:
                    this.J = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.J);
                    break;
                case 9:
                    this.f116v = o.f(typedArrayObtainStyledAttributes, index, this.f116v);
                    break;
                case 10:
                    this.f115u = o.f(typedArrayObtainStyledAttributes, index, this.f115u);
                    break;
                case 11:
                    this.P = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.P);
                    break;
                case 12:
                    this.Q = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.Q);
                    break;
                case 13:
                    this.M = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.M);
                    break;
                case 14:
                    this.O = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.O);
                    break;
                case 15:
                    this.R = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.R);
                    break;
                case 16:
                    this.N = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.N);
                    break;
                case 17:
                    this.f89d = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f89d);
                    break;
                case 18:
                    this.f91e = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f91e);
                    break;
                case 19:
                    this.f = typedArrayObtainStyledAttributes.getFloat(index, this.f);
                    break;
                case 20:
                    this.f117w = typedArrayObtainStyledAttributes.getFloat(index, this.f117w);
                    break;
                case 21:
                    this.f87c = typedArrayObtainStyledAttributes.getLayoutDimension(index, this.f87c);
                    break;
                case 22:
                    this.f85b = typedArrayObtainStyledAttributes.getLayoutDimension(index, this.f85b);
                    break;
                case 23:
                    this.F = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.F);
                    break;
                case 24:
                    this.f96h = o.f(typedArrayObtainStyledAttributes, index, this.f96h);
                    break;
                case 25:
                    this.i = o.f(typedArrayObtainStyledAttributes, index, this.i);
                    break;
                case 26:
                    this.E = typedArrayObtainStyledAttributes.getInt(index, this.E);
                    break;
                case 27:
                    this.G = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.G);
                    break;
                case 28:
                    this.f99j = o.f(typedArrayObtainStyledAttributes, index, this.f99j);
                    break;
                case 29:
                    this.f101k = o.f(typedArrayObtainStyledAttributes, index, this.f101k);
                    break;
                case 30:
                    this.K = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.K);
                    break;
                case 31:
                    this.f113s = o.f(typedArrayObtainStyledAttributes, index, this.f113s);
                    break;
                case 32:
                    this.f114t = o.f(typedArrayObtainStyledAttributes, index, this.f114t);
                    break;
                case 33:
                    this.H = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.H);
                    break;
                case 34:
                    this.f104m = o.f(typedArrayObtainStyledAttributes, index, this.f104m);
                    break;
                case 35:
                    this.f103l = o.f(typedArrayObtainStyledAttributes, index, this.f103l);
                    break;
                case 36:
                    this.f118x = typedArrayObtainStyledAttributes.getFloat(index, this.f118x);
                    break;
                case 37:
                    this.U = typedArrayObtainStyledAttributes.getFloat(index, this.U);
                    break;
                case 38:
                    this.T = typedArrayObtainStyledAttributes.getFloat(index, this.T);
                    break;
                case 39:
                    this.V = typedArrayObtainStyledAttributes.getInt(index, this.V);
                    break;
                case 40:
                    this.W = typedArrayObtainStyledAttributes.getInt(index, this.W);
                    break;
                case 41:
                    o.g(this, typedArrayObtainStyledAttributes, index, 0);
                    break;
                case 42:
                    o.g(this, typedArrayObtainStyledAttributes, index, 1);
                    break;
                default:
                    switch (i10) {
                        case 61:
                            this.f120z = o.f(typedArrayObtainStyledAttributes, index, this.f120z);
                            break;
                        case 62:
                            this.A = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.A);
                            break;
                        case 63:
                            this.B = typedArrayObtainStyledAttributes.getFloat(index, this.B);
                            break;
                        default:
                            switch (i10) {
                                case 69:
                                    this.f90d0 = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                                    break;
                                case 70:
                                    this.f92e0 = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                                    break;
                                case 71:
                                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                                    break;
                                case 72:
                                    this.f93f0 = typedArrayObtainStyledAttributes.getInt(index, this.f93f0);
                                    break;
                                case 73:
                                    this.f95g0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f95g0);
                                    break;
                                case 74:
                                    this.f100j0 = typedArrayObtainStyledAttributes.getString(index);
                                    break;
                                case 75:
                                    this.f107n0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f107n0);
                                    break;
                                case 76:
                                    this.f109o0 = typedArrayObtainStyledAttributes.getInt(index, this.f109o0);
                                    break;
                                case 77:
                                    this.f111q = o.f(typedArrayObtainStyledAttributes, index, this.f111q);
                                    break;
                                case 78:
                                    this.f112r = o.f(typedArrayObtainStyledAttributes, index, this.f112r);
                                    break;
                                case 79:
                                    this.S = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.S);
                                    break;
                                case 80:
                                    this.L = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.L);
                                    break;
                                case 81:
                                    this.X = typedArrayObtainStyledAttributes.getInt(index, this.X);
                                    break;
                                case 82:
                                    this.Y = typedArrayObtainStyledAttributes.getInt(index, this.Y);
                                    break;
                                case 83:
                                    this.f84a0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f84a0);
                                    break;
                                case 84:
                                    this.Z = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.Z);
                                    break;
                                case 85:
                                    this.f88c0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f88c0);
                                    break;
                                case 86:
                                    this.f86b0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f86b0);
                                    break;
                                case 87:
                                    this.l0 = typedArrayObtainStyledAttributes.getBoolean(index, this.l0);
                                    break;
                                case 88:
                                    this.f105m0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f105m0);
                                    break;
                                case 89:
                                    this.f102k0 = typedArrayObtainStyledAttributes.getString(index);
                                    break;
                                case 90:
                                    this.f94g = typedArrayObtainStyledAttributes.getBoolean(index, this.f94g);
                                    break;
                                case 91:
                                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray.get(index));
                                    break;
                                default:
                                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray.get(index));
                                    break;
                            }
                            break;
                    }
                    break;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
