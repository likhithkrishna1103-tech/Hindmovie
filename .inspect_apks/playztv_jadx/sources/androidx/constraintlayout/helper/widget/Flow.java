package androidx.constraintlayout.helper.widget;

import a0.s;
import a0.u;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import java.util.ArrayList;
import java.util.HashMap;
import x.e;
import x.h;
import y.b;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class Flow extends u {
    public final h D;

    public Flow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6u = new int[32];
        this.A = new HashMap();
        this.f8w = context;
        super.g(attributeSet);
        h hVar = new h();
        hVar.f14187s0 = 0;
        hVar.f14188t0 = 0;
        hVar.f14189u0 = 0;
        hVar.f14190v0 = 0;
        hVar.f14191w0 = 0;
        hVar.f14192x0 = 0;
        hVar.f14193y0 = false;
        hVar.f14194z0 = 0;
        hVar.A0 = 0;
        hVar.B0 = new b();
        hVar.C0 = null;
        hVar.D0 = -1;
        hVar.E0 = -1;
        hVar.F0 = -1;
        hVar.G0 = -1;
        hVar.H0 = -1;
        hVar.I0 = -1;
        hVar.J0 = 0.5f;
        hVar.K0 = 0.5f;
        hVar.L0 = 0.5f;
        hVar.M0 = 0.5f;
        hVar.N0 = 0.5f;
        hVar.O0 = 0.5f;
        hVar.P0 = 0;
        hVar.Q0 = 0;
        hVar.R0 = 2;
        hVar.S0 = 2;
        hVar.T0 = 0;
        hVar.U0 = -1;
        hVar.V0 = 0;
        hVar.W0 = new ArrayList();
        hVar.X0 = null;
        hVar.Y0 = null;
        hVar.Z0 = null;
        hVar.f14186b1 = 0;
        this.D = hVar;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, s.ConstraintLayout_Layout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == s.ConstraintLayout_Layout_android_orientation) {
                    this.D.V0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == s.ConstraintLayout_Layout_android_padding) {
                    h hVar2 = this.D;
                    int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                    hVar2.f14187s0 = dimensionPixelSize;
                    hVar2.f14188t0 = dimensionPixelSize;
                    hVar2.f14189u0 = dimensionPixelSize;
                    hVar2.f14190v0 = dimensionPixelSize;
                } else if (index == s.ConstraintLayout_Layout_android_paddingStart) {
                    h hVar3 = this.D;
                    int dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                    hVar3.f14189u0 = dimensionPixelSize2;
                    hVar3.f14191w0 = dimensionPixelSize2;
                    hVar3.f14192x0 = dimensionPixelSize2;
                } else if (index == s.ConstraintLayout_Layout_android_paddingEnd) {
                    this.D.f14190v0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == s.ConstraintLayout_Layout_android_paddingLeft) {
                    this.D.f14191w0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == s.ConstraintLayout_Layout_android_paddingTop) {
                    this.D.f14187s0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == s.ConstraintLayout_Layout_android_paddingRight) {
                    this.D.f14192x0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == s.ConstraintLayout_Layout_android_paddingBottom) {
                    this.D.f14188t0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == s.ConstraintLayout_Layout_flow_wrapMode) {
                    this.D.T0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == s.ConstraintLayout_Layout_flow_horizontalStyle) {
                    this.D.D0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == s.ConstraintLayout_Layout_flow_verticalStyle) {
                    this.D.E0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == s.ConstraintLayout_Layout_flow_firstHorizontalStyle) {
                    this.D.F0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == s.ConstraintLayout_Layout_flow_lastHorizontalStyle) {
                    this.D.H0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == s.ConstraintLayout_Layout_flow_firstVerticalStyle) {
                    this.D.G0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == s.ConstraintLayout_Layout_flow_lastVerticalStyle) {
                    this.D.I0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == s.ConstraintLayout_Layout_flow_horizontalBias) {
                    this.D.J0 = typedArrayObtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == s.ConstraintLayout_Layout_flow_firstHorizontalBias) {
                    this.D.L0 = typedArrayObtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == s.ConstraintLayout_Layout_flow_lastHorizontalBias) {
                    this.D.N0 = typedArrayObtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == s.ConstraintLayout_Layout_flow_firstVerticalBias) {
                    this.D.M0 = typedArrayObtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == s.ConstraintLayout_Layout_flow_lastVerticalBias) {
                    this.D.O0 = typedArrayObtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == s.ConstraintLayout_Layout_flow_verticalBias) {
                    this.D.K0 = typedArrayObtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == s.ConstraintLayout_Layout_flow_horizontalAlign) {
                    this.D.R0 = typedArrayObtainStyledAttributes.getInt(index, 2);
                } else if (index == s.ConstraintLayout_Layout_flow_verticalAlign) {
                    this.D.S0 = typedArrayObtainStyledAttributes.getInt(index, 2);
                } else if (index == s.ConstraintLayout_Layout_flow_horizontalGap) {
                    this.D.P0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == s.ConstraintLayout_Layout_flow_verticalGap) {
                    this.D.Q0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == s.ConstraintLayout_Layout_flow_maxElementsWrap) {
                    this.D.U0 = typedArrayObtainStyledAttributes.getInt(index, -1);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        this.f9x = this.D;
        i();
    }

    @Override // a0.c
    public final void h(e eVar, boolean z2) {
        h hVar = this.D;
        int i = hVar.f14189u0;
        if (i > 0 || hVar.f14190v0 > 0) {
            if (z2) {
                hVar.f14191w0 = hVar.f14190v0;
                hVar.f14192x0 = i;
            } else {
                hVar.f14191w0 = i;
                hVar.f14192x0 = hVar.f14190v0;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:391:0x068d  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:405:0x0728  */
    /* JADX WARN: Removed duplicated region for block: B:411:0x0736  */
    /* JADX WARN: Removed duplicated region for block: B:412:0x0739  */
    /* JADX WARN: Removed duplicated region for block: B:419:0x0755  */
    /* JADX WARN: Removed duplicated region for block: B:420:0x0757  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:430:0x010f A[EDGE_INSN: B:430:0x010f->B:63:0x010f BREAK  A[LOOP:1: B:57:0x00f8->B:62:0x010a], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0140  */
    @Override // a0.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j(x.h r39, int r40, int r41) {
        /*
            Method dump skipped, instruction units count: 1899
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.helper.widget.Flow.j(x.h, int, int):void");
    }

    @Override // a0.c, android.view.View
    public final void onMeasure(int i, int i10) {
        j(this.D, i, i10);
    }

    public void setFirstHorizontalBias(float f) {
        this.D.L0 = f;
        requestLayout();
    }

    public void setFirstHorizontalStyle(int i) {
        this.D.F0 = i;
        requestLayout();
    }

    public void setFirstVerticalBias(float f) {
        this.D.M0 = f;
        requestLayout();
    }

    public void setFirstVerticalStyle(int i) {
        this.D.G0 = i;
        requestLayout();
    }

    public void setHorizontalAlign(int i) {
        this.D.R0 = i;
        requestLayout();
    }

    public void setHorizontalBias(float f) {
        this.D.J0 = f;
        requestLayout();
    }

    public void setHorizontalGap(int i) {
        this.D.P0 = i;
        requestLayout();
    }

    public void setHorizontalStyle(int i) {
        this.D.D0 = i;
        requestLayout();
    }

    public void setLastHorizontalBias(float f) {
        this.D.N0 = f;
        requestLayout();
    }

    public void setLastHorizontalStyle(int i) {
        this.D.H0 = i;
        requestLayout();
    }

    public void setLastVerticalBias(float f) {
        this.D.O0 = f;
        requestLayout();
    }

    public void setLastVerticalStyle(int i) {
        this.D.I0 = i;
        requestLayout();
    }

    public void setMaxElementsWrap(int i) {
        this.D.U0 = i;
        requestLayout();
    }

    public void setOrientation(int i) {
        this.D.V0 = i;
        requestLayout();
    }

    public void setPadding(int i) {
        h hVar = this.D;
        hVar.f14187s0 = i;
        hVar.f14188t0 = i;
        hVar.f14189u0 = i;
        hVar.f14190v0 = i;
        requestLayout();
    }

    public void setPaddingBottom(int i) {
        this.D.f14188t0 = i;
        requestLayout();
    }

    public void setPaddingLeft(int i) {
        this.D.f14191w0 = i;
        requestLayout();
    }

    public void setPaddingRight(int i) {
        this.D.f14192x0 = i;
        requestLayout();
    }

    public void setPaddingTop(int i) {
        this.D.f14187s0 = i;
        requestLayout();
    }

    public void setVerticalAlign(int i) {
        this.D.S0 = i;
        requestLayout();
    }

    public void setVerticalBias(float f) {
        this.D.K0 = f;
        requestLayout();
    }

    public void setVerticalGap(int i) {
        this.D.Q0 = i;
        requestLayout();
    }

    public void setVerticalStyle(int i) {
        this.D.E0 = i;
        requestLayout();
    }

    public void setWrapMode(int i) {
        this.D.T0 = i;
        requestLayout();
    }
}
