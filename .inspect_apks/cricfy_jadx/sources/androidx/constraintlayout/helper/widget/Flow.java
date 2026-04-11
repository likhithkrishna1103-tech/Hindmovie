package androidx.constraintlayout.helper.widget;

import a0.d;
import a0.g;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import b0.b;
import d0.r;
import d0.t;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class Flow extends t {
    public final g E;

    public Flow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3063v = new int[32];
        this.B = new HashMap();
        this.f3065x = context;
        super.g(attributeSet);
        g gVar = new g();
        gVar.f93s0 = 0;
        gVar.f94t0 = 0;
        gVar.f95u0 = 0;
        gVar.f96v0 = 0;
        gVar.f97w0 = 0;
        gVar.f98x0 = 0;
        gVar.f99y0 = false;
        gVar.f100z0 = 0;
        gVar.A0 = 0;
        gVar.B0 = new b();
        gVar.C0 = null;
        gVar.D0 = -1;
        gVar.E0 = -1;
        gVar.F0 = -1;
        gVar.G0 = -1;
        gVar.H0 = -1;
        gVar.I0 = -1;
        gVar.J0 = 0.5f;
        gVar.K0 = 0.5f;
        gVar.L0 = 0.5f;
        gVar.M0 = 0.5f;
        gVar.N0 = 0.5f;
        gVar.O0 = 0.5f;
        gVar.P0 = 0;
        gVar.Q0 = 0;
        gVar.R0 = 2;
        gVar.S0 = 2;
        gVar.T0 = 0;
        gVar.U0 = -1;
        gVar.V0 = 0;
        gVar.W0 = new ArrayList();
        gVar.X0 = null;
        gVar.Y0 = null;
        gVar.Z0 = null;
        gVar.f92b1 = 0;
        this.E = gVar;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, r.ConstraintLayout_Layout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == r.ConstraintLayout_Layout_android_orientation) {
                    this.E.V0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == r.ConstraintLayout_Layout_android_padding) {
                    g gVar2 = this.E;
                    int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                    gVar2.f93s0 = dimensionPixelSize;
                    gVar2.f94t0 = dimensionPixelSize;
                    gVar2.f95u0 = dimensionPixelSize;
                    gVar2.f96v0 = dimensionPixelSize;
                } else if (index == r.ConstraintLayout_Layout_android_paddingStart) {
                    g gVar3 = this.E;
                    int dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                    gVar3.f95u0 = dimensionPixelSize2;
                    gVar3.f97w0 = dimensionPixelSize2;
                    gVar3.f98x0 = dimensionPixelSize2;
                } else if (index == r.ConstraintLayout_Layout_android_paddingEnd) {
                    this.E.f96v0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == r.ConstraintLayout_Layout_android_paddingLeft) {
                    this.E.f97w0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == r.ConstraintLayout_Layout_android_paddingTop) {
                    this.E.f93s0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == r.ConstraintLayout_Layout_android_paddingRight) {
                    this.E.f98x0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == r.ConstraintLayout_Layout_android_paddingBottom) {
                    this.E.f94t0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == r.ConstraintLayout_Layout_flow_wrapMode) {
                    this.E.T0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == r.ConstraintLayout_Layout_flow_horizontalStyle) {
                    this.E.D0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == r.ConstraintLayout_Layout_flow_verticalStyle) {
                    this.E.E0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == r.ConstraintLayout_Layout_flow_firstHorizontalStyle) {
                    this.E.F0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == r.ConstraintLayout_Layout_flow_lastHorizontalStyle) {
                    this.E.H0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == r.ConstraintLayout_Layout_flow_firstVerticalStyle) {
                    this.E.G0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == r.ConstraintLayout_Layout_flow_lastVerticalStyle) {
                    this.E.I0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == r.ConstraintLayout_Layout_flow_horizontalBias) {
                    this.E.J0 = typedArrayObtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == r.ConstraintLayout_Layout_flow_firstHorizontalBias) {
                    this.E.L0 = typedArrayObtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == r.ConstraintLayout_Layout_flow_lastHorizontalBias) {
                    this.E.N0 = typedArrayObtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == r.ConstraintLayout_Layout_flow_firstVerticalBias) {
                    this.E.M0 = typedArrayObtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == r.ConstraintLayout_Layout_flow_lastVerticalBias) {
                    this.E.O0 = typedArrayObtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == r.ConstraintLayout_Layout_flow_verticalBias) {
                    this.E.K0 = typedArrayObtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == r.ConstraintLayout_Layout_flow_horizontalAlign) {
                    this.E.R0 = typedArrayObtainStyledAttributes.getInt(index, 2);
                } else if (index == r.ConstraintLayout_Layout_flow_verticalAlign) {
                    this.E.S0 = typedArrayObtainStyledAttributes.getInt(index, 2);
                } else if (index == r.ConstraintLayout_Layout_flow_horizontalGap) {
                    this.E.P0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == r.ConstraintLayout_Layout_flow_verticalGap) {
                    this.E.Q0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == r.ConstraintLayout_Layout_flow_maxElementsWrap) {
                    this.E.U0 = typedArrayObtainStyledAttributes.getInt(index, -1);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        this.f3066y = this.E;
        i();
    }

    @Override // d0.c
    public final void h(d dVar, boolean z10) {
        g gVar = this.E;
        int i = gVar.f95u0;
        if (i > 0 || gVar.f96v0 > 0) {
            if (z10) {
                gVar.f97w0 = gVar.f96v0;
                gVar.f98x0 = i;
            } else {
                gVar.f97w0 = i;
                gVar.f98x0 = gVar.f96v0;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:391:0x068f  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:405:0x072a  */
    /* JADX WARN: Removed duplicated region for block: B:411:0x0738  */
    /* JADX WARN: Removed duplicated region for block: B:412:0x073b  */
    /* JADX WARN: Removed duplicated region for block: B:419:0x0757  */
    /* JADX WARN: Removed duplicated region for block: B:420:0x0759  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:430:0x010f A[EDGE_INSN: B:430:0x010f->B:63:0x010f BREAK  A[LOOP:1: B:57:0x00f8->B:62:0x010a], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0140  */
    @Override // d0.t
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j(a0.g r39, int r40, int r41) {
        /*
            Method dump skipped, instruction units count: 1901
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.helper.widget.Flow.j(a0.g, int, int):void");
    }

    @Override // d0.c, android.view.View
    public final void onMeasure(int i, int i10) {
        j(this.E, i, i10);
    }

    public void setFirstHorizontalBias(float f) {
        this.E.L0 = f;
        requestLayout();
    }

    public void setFirstHorizontalStyle(int i) {
        this.E.F0 = i;
        requestLayout();
    }

    public void setFirstVerticalBias(float f) {
        this.E.M0 = f;
        requestLayout();
    }

    public void setFirstVerticalStyle(int i) {
        this.E.G0 = i;
        requestLayout();
    }

    public void setHorizontalAlign(int i) {
        this.E.R0 = i;
        requestLayout();
    }

    public void setHorizontalBias(float f) {
        this.E.J0 = f;
        requestLayout();
    }

    public void setHorizontalGap(int i) {
        this.E.P0 = i;
        requestLayout();
    }

    public void setHorizontalStyle(int i) {
        this.E.D0 = i;
        requestLayout();
    }

    public void setLastHorizontalBias(float f) {
        this.E.N0 = f;
        requestLayout();
    }

    public void setLastHorizontalStyle(int i) {
        this.E.H0 = i;
        requestLayout();
    }

    public void setLastVerticalBias(float f) {
        this.E.O0 = f;
        requestLayout();
    }

    public void setLastVerticalStyle(int i) {
        this.E.I0 = i;
        requestLayout();
    }

    public void setMaxElementsWrap(int i) {
        this.E.U0 = i;
        requestLayout();
    }

    public void setOrientation(int i) {
        this.E.V0 = i;
        requestLayout();
    }

    public void setPadding(int i) {
        g gVar = this.E;
        gVar.f93s0 = i;
        gVar.f94t0 = i;
        gVar.f95u0 = i;
        gVar.f96v0 = i;
        requestLayout();
    }

    public void setPaddingBottom(int i) {
        this.E.f94t0 = i;
        requestLayout();
    }

    public void setPaddingLeft(int i) {
        this.E.f97w0 = i;
        requestLayout();
    }

    public void setPaddingRight(int i) {
        this.E.f98x0 = i;
        requestLayout();
    }

    public void setPaddingTop(int i) {
        this.E.f93s0 = i;
        requestLayout();
    }

    public void setVerticalAlign(int i) {
        this.E.S0 = i;
        requestLayout();
    }

    public void setVerticalBias(float f) {
        this.E.K0 = f;
        requestLayout();
    }

    public void setVerticalGap(int i) {
        this.E.Q0 = i;
        requestLayout();
    }

    public void setVerticalStyle(int i) {
        this.E.E0 = i;
        requestLayout();
    }

    public void setWrapMode(int i) {
        this.E.T0 = i;
        requestLayout();
    }
}
