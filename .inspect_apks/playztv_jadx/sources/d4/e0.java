package d4;

import a2.f2;
import android.opengl.GLES20;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.HashMap;
import n.a1;
import q4.x0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e0 implements b0 {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f3836u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f3837v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Object f3838w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Object f3839x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Cloneable f3840y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Object f3841z;

    public e0(q0.e eVar) {
        this.f3836u = 1;
        this.f3837v = 0;
        this.f3838w = eVar;
        this.f3839x = new af.a(8);
        this.f3840y = new ArrayList();
    }

    public static void a(int i, int i10, String str) throws s1.k {
        int iGlCreateShader = GLES20.glCreateShader(i10);
        GLES20.glShaderSource(iGlCreateShader, str);
        GLES20.glCompileShader(iGlCreateShader);
        int[] iArr = {0};
        GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
        s1.b.d(GLES20.glGetShaderInfoLog(iGlCreateShader) + ", source: \n" + str, iArr[0] == 1);
        GLES20.glAttachShader(i, iGlCreateShader);
        GLES20.glDeleteShader(iGlCreateShader);
        s1.b.c();
    }

    public void b(View view, int i, boolean z2) {
        RecyclerView recyclerView = (RecyclerView) ((q0.e) this.f3838w).f10436v;
        int childCount = i < 0 ? recyclerView.getChildCount() : j(i);
        ((af.a) this.f3839x).H(childCount, z2);
        if (z2) {
            m(view);
        }
        recyclerView.addView(view, childCount);
        RecyclerView.M(view);
    }

    public void c(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z2) {
        RecyclerView recyclerView = (RecyclerView) ((q0.e) this.f3838w).f10436v;
        int childCount = i < 0 ? recyclerView.getChildCount() : j(i);
        ((af.a) this.f3839x).H(childCount, z2);
        if (z2) {
            m(view);
        }
        x0 x0VarM = RecyclerView.M(view);
        if (x0VarM != null) {
            if (!x0VarM.j() && !x0VarM.o()) {
                StringBuilder sb2 = new StringBuilder("Called attach on a child which is not detached: ");
                sb2.append(x0VarM);
                throw new IllegalArgumentException(e6.j.k(recyclerView, sb2));
            }
            if (RecyclerView.W0) {
                Log.d("RecyclerView", "reAttach " + x0VarM);
            }
            x0VarM.f10969j &= -257;
        } else if (RecyclerView.V0) {
            StringBuilder sb3 = new StringBuilder("No ViewHolder found for child: ");
            sb3.append(view);
            sb3.append(", index: ");
            sb3.append(childCount);
            throw new IllegalArgumentException(e6.j.k(recyclerView, sb3));
        }
        recyclerView.attachViewToParent(view, childCount, layoutParams);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0141  */
    @Override // d4.b0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d(s1.u r38) {
        /*
            Method dump skipped, instruction units count: 761
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d4.e0.d(s1.u):void");
    }

    public void f(int i) {
        int iJ = j(i);
        ((af.a) this.f3839x).J(iJ);
        RecyclerView recyclerView = (RecyclerView) ((q0.e) this.f3838w).f10436v;
        View childAt = recyclerView.getChildAt(iJ);
        if (childAt != null) {
            x0 x0VarM = RecyclerView.M(childAt);
            if (x0VarM != null) {
                if (x0VarM.j() && !x0VarM.o()) {
                    StringBuilder sb2 = new StringBuilder("called detach on an already detached child ");
                    sb2.append(x0VarM);
                    throw new IllegalArgumentException(e6.j.k(recyclerView, sb2));
                }
                if (RecyclerView.W0) {
                    Log.d("RecyclerView", "tmpDetach " + x0VarM);
                }
                x0VarM.a(256);
            }
        } else if (RecyclerView.V0) {
            StringBuilder sb3 = new StringBuilder("No view at offset ");
            sb3.append(iJ);
            throw new IllegalArgumentException(e6.j.k(recyclerView, sb3));
        }
        recyclerView.detachViewFromParent(iJ);
    }

    public int g(String str) throws s1.k {
        int iGlGetAttribLocation = GLES20.glGetAttribLocation(this.f3837v, str);
        GLES20.glEnableVertexAttribArray(iGlGetAttribLocation);
        s1.b.c();
        return iGlGetAttribLocation;
    }

    public View h(int i) {
        return ((RecyclerView) ((q0.e) this.f3838w).f10436v).getChildAt(j(i));
    }

    public int i() {
        return ((RecyclerView) ((q0.e) this.f3838w).f10436v).getChildCount() - ((ArrayList) this.f3840y).size();
    }

    public int j(int i) {
        af.a aVar = (af.a) this.f3839x;
        if (i < 0) {
            return -1;
        }
        int childCount = ((RecyclerView) ((q0.e) this.f3838w).f10436v).getChildCount();
        int i10 = i;
        while (i10 < childCount) {
            int iD = i - (i10 - aVar.D(i10));
            if (iD == 0) {
                while (aVar.G(i10)) {
                    i10++;
                }
                return i10;
            }
            i10 += iD;
        }
        return -1;
    }

    public View k(int i) {
        return ((RecyclerView) ((q0.e) this.f3838w).f10436v).getChildAt(i);
    }

    public int l() {
        return ((RecyclerView) ((q0.e) this.f3838w).f10436v).getChildCount();
    }

    public void m(View view) {
        ((ArrayList) this.f3840y).add(view);
        q0.e eVar = (q0.e) this.f3838w;
        x0 x0VarM = RecyclerView.M(view);
        if (x0VarM != null) {
            View view2 = x0VarM.f10962a;
            RecyclerView recyclerView = (RecyclerView) eVar.f10436v;
            int i = x0VarM.f10976q;
            if (i != -1) {
                x0VarM.f10975p = i;
            } else {
                x0VarM.f10975p = view2.getImportantForAccessibility();
            }
            if (!recyclerView.P()) {
                view2.setImportantForAccessibility(4);
            } else {
                x0VarM.f10976q = 4;
                recyclerView.N0.add(x0VarM);
            }
        }
    }

    public void n(View view) {
        if (((ArrayList) this.f3840y).remove(view)) {
            q0.e eVar = (q0.e) this.f3838w;
            x0 x0VarM = RecyclerView.M(view);
            if (x0VarM != null) {
                RecyclerView recyclerView = (RecyclerView) eVar.f10436v;
                int i = x0VarM.f10975p;
                if (recyclerView.P()) {
                    x0VarM.f10976q = i;
                    recyclerView.N0.add(x0VarM);
                } else {
                    x0VarM.f10962a.setImportantForAccessibility(i);
                }
                x0VarM.f10975p = 0;
            }
        }
    }

    public String toString() {
        switch (this.f3836u) {
            case 1:
                return ((af.a) this.f3839x).toString() + ", hidden list:" + ((ArrayList) this.f3840y).size();
            default:
                return super.toString();
        }
    }

    public e0(String str, String str2) throws s1.k {
        this.f3836u = 3;
        int iGlCreateProgram = GLES20.glCreateProgram();
        this.f3837v = iGlCreateProgram;
        s1.b.c();
        a(iGlCreateProgram, 35633, str);
        a(iGlCreateProgram, 35632, str2);
        GLES20.glLinkProgram(iGlCreateProgram);
        int[] iArr = {0};
        GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr, 0);
        s1.b.d("Unable to link shader program: \n" + GLES20.glGetProgramInfoLog(iGlCreateProgram), iArr[0] == 1);
        GLES20.glUseProgram(iGlCreateProgram);
        this.f3840y = new HashMap();
        int[] iArr2 = new int[1];
        GLES20.glGetProgramiv(iGlCreateProgram, 35721, iArr2, 0);
        this.f3838w = new k8.c0[iArr2[0]];
        for (int i = 0; i < iArr2[0]; i++) {
            int i10 = this.f3837v;
            int[] iArr3 = new int[1];
            GLES20.glGetProgramiv(i10, 35722, iArr3, 0);
            int i11 = iArr3[0];
            byte[] bArr = new byte[i11];
            GLES20.glGetActiveAttrib(i10, i, i11, new int[1], 0, new int[1], 0, new int[1], 0, bArr, 0);
            int i12 = 0;
            while (true) {
                if (i12 >= i11) {
                    break;
                }
                if (bArr[i12] == 0) {
                    i11 = i12;
                    break;
                }
                i12++;
            }
            String str3 = new String(bArr, 0, i11);
            GLES20.glGetAttribLocation(i10, str3);
            k8.c0 c0Var = new k8.c0(24);
            ((k8.c0[]) this.f3838w)[i] = c0Var;
            ((HashMap) this.f3840y).put(str3, c0Var);
        }
        this.f3841z = new HashMap();
        int[] iArr4 = new int[1];
        GLES20.glGetProgramiv(this.f3837v, 35718, iArr4, 0);
        this.f3839x = new k8.z[iArr4[0]];
        for (int i13 = 0; i13 < iArr4[0]; i13++) {
            int i14 = this.f3837v;
            int[] iArr5 = new int[1];
            GLES20.glGetProgramiv(i14, 35719, iArr5, 0);
            int i15 = iArr5[0];
            byte[] bArr2 = new byte[i15];
            GLES20.glGetActiveUniform(i14, i13, i15, new int[1], 0, new int[1], 0, new int[1], 0, bArr2, 0);
            int i16 = 0;
            while (true) {
                if (i16 >= i15) {
                    break;
                }
                if (bArr2[i16] == 0) {
                    i15 = i16;
                    break;
                }
                i16++;
            }
            String str4 = new String(bArr2, 0, i15);
            GLES20.glGetUniformLocation(i14, str4);
            k8.z zVar = new k8.z(25);
            ((k8.z[]) this.f3839x)[i13] = zVar;
            ((HashMap) this.f3841z).put(str4, zVar);
        }
        s1.b.c();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e0(w2.z zVar, a1 a1Var, byte[] bArr, f2[] f2VarArr, int i) {
        this.f3836u = 2;
        this.f3838w = zVar;
        this.f3839x = a1Var;
        this.f3840y = bArr;
        this.f3841z = f2VarArr;
        this.f3837v = i;
    }

    public e0(f0 f0Var, int i) {
        this.f3836u = 0;
        this.f3841z = f0Var;
        this.f3838w = new s1.t(5, new byte[5]);
        this.f3839x = new SparseArray();
        this.f3840y = new SparseIntArray();
        this.f3837v = i;
    }

    @Override // d4.b0
    public void e(s1.z zVar, w2.q qVar, h0 h0Var) {
    }
}
