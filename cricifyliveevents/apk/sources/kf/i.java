package kf;

import a3.h0;
import android.R;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContentInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import app.cricfy.tv.activities.PlayerActivity;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.android.material.chip.ChipGroup;
import da.f0;
import f9.x0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
import s2.b1;
import s2.c1;
import s2.l1;
import v1.g1;
import v1.n0;
import v4.e1;
import v4.i0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class i implements l2.z, lb.b, mb.a, b1, j9.h, n.v, n.i, o8.c, of.h, m4.y, z5.i, t0.e, e1, v9.f, t0.h, z7.b, t7.a {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f7482v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Object f7483w;

    public /* synthetic */ i(int i, Object obj) {
        this.f7482v = i;
        this.f7483w = obj;
    }

    public static String M(String str, Bundle bundle) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        for (String str2 : bundle.keySet()) {
            jSONObject2.put(str2, bundle.get(str2));
        }
        jSONObject.put("name", str);
        jSONObject.put("parameters", jSONObject2);
        return jSONObject.toString();
    }

    @Override // lb.b
    public void A(String str, Bundle bundle) {
        nb.n nVar = (nb.n) this.f7483w;
        if (nVar != null) {
            try {
                String str2 = "$A$:" + M(str, bundle);
                nb.p pVar = nVar.f8973a;
                pVar.f8990o.f9742a.a(new nb.o(pVar, System.currentTimeMillis() - pVar.f8981d, str2, 0));
            } catch (JSONException unused) {
                Log.w("FirebaseCrashlytics", "Unable to serialize Firebase Analytics event to breadcrumb.", null);
            }
        }
    }

    @Override // j9.h
    public j9.p B(Object obj) {
        vb.a aVar = (vb.a) obj;
        i2.k kVar = (i2.k) this.f7483w;
        if (aVar == null) {
            Log.w("FirebaseCrashlytics", "Received null app settings at app startup. Cannot send cached reports", null);
            return vf.g.A(null);
        }
        nb.l lVar = (nb.l) kVar.f6086w;
        nb.l.a(lVar);
        lVar.f8965m.w(null, lVar.f8959e.f9742a);
        lVar.f8969q.c(null);
        return vf.g.A(null);
    }

    @Override // t0.h
    public void C() {
        ((NestedScrollView) this.f7483w).f673y.abortAnimation();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void D(int i, int i10, a3.q qVar) throws n0 {
        int i11;
        int i12;
        int i13;
        long j4;
        int i14;
        int i15;
        int i16;
        int i17;
        s3.d dVar = (s3.d) this.f7483w;
        s3.e eVar = dVar.f11438b;
        SparseArray sparseArray = dVar.f11440c;
        y1.t tVar = dVar.f11449k;
        y1.t tVar2 = dVar.i;
        int i18 = 1;
        int i19 = 0;
        if (i != 161 && i != 163) {
            if (i == 165) {
                if (dVar.J != 2) {
                    return;
                }
                s3.c cVar = (s3.c) sparseArray.get(dVar.P);
                int i20 = dVar.S;
                y1.t tVar3 = dVar.f11454p;
                if (i20 != 4 || !"V_VP9".equals(cVar.f11408c)) {
                    qVar.n(i10);
                    return;
                } else {
                    tVar3.G(i10);
                    qVar.readFully(tVar3.f14609a, 0, i10);
                    return;
                }
            }
            if (i == 16877) {
                dVar.d(i);
                s3.c cVar2 = dVar.f11462x;
                int i21 = cVar2.f11412h;
                if (i21 != 1685485123 && i21 != 1685480259) {
                    qVar.n(i10);
                    return;
                }
                byte[] bArr = new byte[i10];
                cVar2.P = bArr;
                qVar.readFully(bArr, 0, i10);
                return;
            }
            if (i == 16981) {
                dVar.d(i);
                byte[] bArr2 = new byte[i10];
                dVar.f11462x.f11413j = bArr2;
                qVar.readFully(bArr2, 0, i10);
                return;
            }
            if (i == 18402) {
                byte[] bArr3 = new byte[i10];
                qVar.readFully(bArr3, 0, i10);
                dVar.d(i);
                dVar.f11462x.f11414k = new h0(1, 0, 0, bArr3);
                return;
            }
            if (i == 21419) {
                Arrays.fill(tVar.f14609a, (byte) 0);
                qVar.readFully(tVar.f14609a, 4 - i10, i10);
                tVar.J(0);
                dVar.f11464z = (int) tVar.z();
                return;
            }
            if (i == 25506) {
                dVar.d(i);
                byte[] bArr4 = new byte[i10];
                dVar.f11462x.f11415l = bArr4;
                qVar.readFully(bArr4, 0, i10);
                return;
            }
            if (i != 30322) {
                throw n0.a(null, "Unexpected id: " + i);
            }
            dVar.d(i);
            byte[] bArr5 = new byte[i10];
            dVar.f11462x.f11427x = bArr5;
            qVar.readFully(bArr5, 0, i10);
            return;
        }
        if (dVar.J == 0) {
            dVar.P = (int) eVar.b(qVar, false, true, 8);
            dVar.Q = eVar.f11468c;
            dVar.L = -9223372036854775807L;
            dVar.J = 1;
            tVar2.G(0);
        }
        s3.c cVar3 = (s3.c) sparseArray.get(dVar.P);
        if (cVar3 == null) {
            qVar.n(i10 - dVar.Q);
            dVar.J = 0;
            return;
        }
        cVar3.Z.getClass();
        if (dVar.J == 1) {
            dVar.k(qVar, 3);
            int i22 = (tVar2.f14609a[2] & 6) >> 1;
            int i23 = 255;
            if (i22 == 0) {
                dVar.N = 1;
                int[] iArr = dVar.O;
                if (iArr == null) {
                    iArr = new int[1];
                } else if (iArr.length < 1) {
                    iArr = new int[Math.max(iArr.length * 2, 1)];
                }
                dVar.O = iArr;
                iArr[0] = (i10 - dVar.Q) - 3;
            } else {
                dVar.k(qVar, 4);
                int i24 = (tVar2.f14609a[3] & 255) + 1;
                dVar.N = i24;
                int[] iArr2 = dVar.O;
                if (iArr2 == null) {
                    iArr2 = new int[i24];
                } else if (iArr2.length < i24) {
                    iArr2 = new int[Math.max(iArr2.length * 2, i24)];
                }
                dVar.O = iArr2;
                if (i22 == 2) {
                    int i25 = (i10 - dVar.Q) - 4;
                    int i26 = dVar.N;
                    Arrays.fill(iArr2, 0, i26, i25 / i26);
                } else {
                    if (i22 != 1) {
                        if (i22 != 3) {
                            throw n0.a(null, "Unexpected lacing value: " + i22);
                        }
                        int i27 = 0;
                        int i28 = 0;
                        int i29 = 4;
                        while (true) {
                            int i30 = dVar.N - i18;
                            if (i27 >= i30) {
                                i11 = i18;
                                i12 = i19;
                                dVar.O[i30] = ((i10 - dVar.Q) - i29) - i28;
                                break;
                            }
                            dVar.O[i27] = i19;
                            int i31 = i29 + 1;
                            dVar.k(qVar, i31);
                            if (tVar2.f14609a[i29] == 0) {
                                throw n0.a(null, "No valid varint length mask found");
                            }
                            int i32 = i18;
                            int i33 = i19;
                            while (true) {
                                if (i33 >= 8) {
                                    i13 = i19;
                                    j4 = 0;
                                    i14 = i31;
                                    break;
                                }
                                int i34 = i32 << (7 - i33);
                                i13 = i19;
                                if ((tVar2.f14609a[i29] & i34) != 0) {
                                    i14 = i31 + i33;
                                    dVar.k(qVar, i14);
                                    j4 = tVar2.f14609a[i29] & i23 & (~i34);
                                    while (i31 < i14) {
                                        j4 = (j4 << 8) | ((long) (tVar2.f14609a[i31] & i23));
                                        i31++;
                                        i23 = 255;
                                    }
                                    if (i27 > 0) {
                                        j4 -= (1 << ((i33 * 7) + 6)) - 1;
                                    }
                                } else {
                                    i33++;
                                    i19 = i13;
                                    i23 = 255;
                                }
                            }
                            if (j4 < -2147483648L || j4 > 2147483647L) {
                                break;
                            }
                            int i35 = (int) j4;
                            int[] iArr3 = dVar.O;
                            if (i27 != 0) {
                                i35 += iArr3[i27 - 1];
                            }
                            iArr3[i27] = i35;
                            i28 += i35;
                            i27++;
                            i29 = i14;
                            i18 = i32;
                            i19 = i13;
                            i23 = 255;
                        }
                        throw n0.a(null, "EBML lacing sample size out of range.");
                    }
                    int i36 = 0;
                    int i37 = 0;
                    int i38 = 4;
                    while (true) {
                        i15 = dVar.N - 1;
                        if (i36 >= i15) {
                            break;
                        }
                        dVar.O[i36] = 0;
                        while (true) {
                            i16 = i38 + 1;
                            dVar.k(qVar, i16);
                            int i39 = tVar2.f14609a[i38] & 255;
                            int[] iArr4 = dVar.O;
                            i17 = iArr4[i36] + i39;
                            iArr4[i36] = i17;
                            if (i39 != 255) {
                                break;
                            } else {
                                i38 = i16;
                            }
                        }
                        i37 += i17;
                        i36++;
                        i38 = i16;
                    }
                    dVar.O[i15] = ((i10 - dVar.Q) - i38) - i37;
                }
            }
            i11 = 1;
            i12 = 0;
            byte[] bArr6 = tVar2.f14609a;
            dVar.K = dVar.m((bArr6[i11] & 255) | (bArr6[i12] << 8)) + dVar.E;
            dVar.R = (cVar3.f11410e == 2 || (i == 163 && (tVar2.f14609a[2] & 128) == 128)) ? i11 : i12;
            dVar.J = 2;
            dVar.M = i12;
        } else {
            i11 = 1;
        }
        if (i == 163) {
            while (true) {
                int i40 = dVar.M;
                if (i40 >= dVar.N) {
                    dVar.J = 0;
                    return;
                } else {
                    dVar.g(cVar3, ((long) ((dVar.M * cVar3.f) / 1000)) + dVar.K, dVar.R, dVar.n(qVar, cVar3, dVar.O[i40], false), 0);
                    dVar.M++;
                }
            }
        } else {
            while (true) {
                int i41 = dVar.M;
                if (i41 >= dVar.N) {
                    return;
                }
                int[] iArr5 = dVar.O;
                boolean z10 = i11;
                iArr5[i41] = dVar.n(qVar, cVar3, iArr5[i41], z10);
                dVar.M += z10 ? 1 : 0;
            }
        }
    }

    public u0.e E(int i) {
        return null;
    }

    public u0.e F(int i) {
        return null;
    }

    public void G() {
        View view = (View) this.f7483w;
        if (view != null) {
            ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public void H(int i, long j4) throws n0 {
        s3.d dVar = (s3.d) this.f7483w;
        if (i == 20529) {
            if (j4 == 0) {
                return;
            }
            throw n0.a(null, "ContentEncodingOrder " + j4 + " not supported");
        }
        if (i == 20530) {
            if (j4 == 1) {
                return;
            }
            throw n0.a(null, "ContentEncodingScope " + j4 + " not supported");
        }
        switch (i) {
            case 131:
                dVar.d(i);
                dVar.f11462x.f11410e = (int) j4;
                return;
            case 136:
                dVar.d(i);
                dVar.f11462x.X = j4 == 1;
                return;
            case ModuleDescriptor.MODULE_VERSION /* 155 */:
                dVar.L = dVar.m(j4);
                return;
            case 159:
                dVar.d(i);
                dVar.f11462x.Q = (int) j4;
                return;
            case 176:
                dVar.d(i);
                dVar.f11462x.f11417n = (int) j4;
                return;
            case 179:
                dVar.b(i);
                dVar.F.a(dVar.m(j4));
                return;
            case 186:
                dVar.d(i);
                dVar.f11462x.f11418o = (int) j4;
                return;
            case 215:
                dVar.d(i);
                dVar.f11462x.f11409d = (int) j4;
                return;
            case 231:
                dVar.E = dVar.m(j4);
                return;
            case 238:
                dVar.S = (int) j4;
                return;
            case 241:
                if (dVar.H) {
                    return;
                }
                dVar.b(i);
                dVar.G.a(j4);
                dVar.H = true;
                return;
            case 251:
                dVar.T = true;
                return;
            case 16871:
                dVar.d(i);
                dVar.f11462x.f11412h = (int) j4;
                return;
            case 16980:
                if (j4 == 3) {
                    return;
                }
                throw n0.a(null, "ContentCompAlgo " + j4 + " not supported");
            case 17029:
                if (j4 < 1 || j4 > 2) {
                    throw n0.a(null, "DocTypeReadVersion " + j4 + " not supported");
                }
                return;
            case 17143:
                if (j4 == 1) {
                    return;
                }
                throw n0.a(null, "EBMLReadVersion " + j4 + " not supported");
            case 18401:
                if (j4 == 5) {
                    return;
                }
                throw n0.a(null, "ContentEncAlgo " + j4 + " not supported");
            case 18408:
                if (j4 == 1) {
                    return;
                }
                throw n0.a(null, "AESSettingsCipherMode " + j4 + " not supported");
            case 21420:
                dVar.A = j4 + dVar.f11457s;
                return;
            case 21432:
                int i10 = (int) j4;
                dVar.d(i);
                if (i10 == 0) {
                    dVar.f11462x.f11428y = 0;
                    return;
                }
                if (i10 == 1) {
                    dVar.f11462x.f11428y = 2;
                    return;
                } else if (i10 == 3) {
                    dVar.f11462x.f11428y = 1;
                    return;
                } else {
                    if (i10 != 15) {
                        return;
                    }
                    dVar.f11462x.f11428y = 3;
                    return;
                }
            case 21680:
                dVar.d(i);
                dVar.f11462x.f11420q = (int) j4;
                return;
            case 21682:
                dVar.d(i);
                dVar.f11462x.f11422s = (int) j4;
                return;
            case 21690:
                dVar.d(i);
                dVar.f11462x.f11421r = (int) j4;
                return;
            case 21930:
                dVar.d(i);
                dVar.f11462x.W = j4 == 1;
                return;
            case 21938:
                dVar.d(i);
                s3.c cVar = dVar.f11462x;
                cVar.f11429z = true;
                cVar.f11419p = (int) j4;
                return;
            case 21998:
                dVar.d(i);
                dVar.f11462x.f11411g = (int) j4;
                return;
            case 22186:
                dVar.d(i);
                dVar.f11462x.T = j4;
                return;
            case 22203:
                dVar.d(i);
                dVar.f11462x.U = j4;
                return;
            case 25188:
                dVar.d(i);
                dVar.f11462x.R = (int) j4;
                return;
            case 30114:
                dVar.U = j4;
                return;
            case 30321:
                dVar.d(i);
                int i11 = (int) j4;
                if (i11 == 0) {
                    dVar.f11462x.f11423t = 0;
                    return;
                }
                if (i11 == 1) {
                    dVar.f11462x.f11423t = 1;
                    return;
                } else if (i11 == 2) {
                    dVar.f11462x.f11423t = 2;
                    return;
                } else {
                    if (i11 != 3) {
                        return;
                    }
                    dVar.f11462x.f11423t = 3;
                    return;
                }
            case 2352003:
                dVar.d(i);
                dVar.f11462x.f = (int) j4;
                return;
            case 2807729:
                dVar.f11458t = j4;
                return;
            default:
                switch (i) {
                    case 21945:
                        dVar.d(i);
                        int i12 = (int) j4;
                        if (i12 == 1) {
                            dVar.f11462x.C = 2;
                            return;
                        } else {
                            if (i12 != 2) {
                                return;
                            }
                            dVar.f11462x.C = 1;
                            return;
                        }
                    case 21946:
                        dVar.d(i);
                        int iG = v1.g.g((int) j4);
                        if (iG != -1) {
                            dVar.f11462x.B = iG;
                            return;
                        }
                        return;
                    case 21947:
                        dVar.d(i);
                        dVar.f11462x.f11429z = true;
                        int iF = v1.g.f((int) j4);
                        if (iF != -1) {
                            dVar.f11462x.A = iF;
                            return;
                        }
                        return;
                    case 21948:
                        dVar.d(i);
                        dVar.f11462x.D = (int) j4;
                        return;
                    case 21949:
                        dVar.d(i);
                        dVar.f11462x.E = (int) j4;
                        return;
                    default:
                        return;
                }
        }
    }

    public void I() {
        m2.l lVar = (m2.l) this.f7483w;
        int i = lVar.M - 1;
        lVar.M = i;
        if (i > 0) {
            return;
        }
        int i10 = 0;
        for (m2.r rVar : lVar.O) {
            rVar.c();
            i10 += rVar.f8114d0.f11262a;
        }
        g1[] g1VarArr = new g1[i10];
        int i11 = 0;
        for (m2.r rVar2 : lVar.O) {
            rVar2.c();
            int i12 = rVar2.f8114d0.f11262a;
            int i13 = 0;
            while (i13 < i12) {
                rVar2.c();
                g1VarArr[i11] = rVar2.f8114d0.a(i13);
                i13++;
                i11++;
            }
        }
        lVar.N = new l1(g1VarArr);
        lVar.L.k(lVar);
    }

    public vb.a J(JSONObject jSONObject) throws JSONException {
        vb.c b0Var;
        int i = jSONObject.getInt("settings_version");
        if (i != 3) {
            Log.e("FirebaseCrashlytics", "Could not determine SettingsJsonTransform for settings version " + i + ". Using default settings values.", null);
            b0Var = new f9.a0(27);
        } else {
            b0Var = new f9.b0(27);
        }
        return b0Var.i((f9.a0) this.f7483w, jSONObject);
    }

    public boolean K(int i, int i10, Bundle bundle) {
        return false;
    }

    public void L(int i) {
        RecyclerView recyclerView = (RecyclerView) this.f7483w;
        View childAt = recyclerView.getChildAt(i);
        if (childAt != null) {
            RecyclerView.M(childAt);
            childAt.clearAnimation();
        }
        recyclerView.removeViewAt(i);
    }

    public void N() {
        View viewFindViewById;
        View view = (View) this.f7483w;
        if (view == null) {
            return;
        }
        if (view.isInEditMode() || view.onCheckIsTextEditor()) {
            view.requestFocus();
            viewFindViewById = view;
        } else {
            viewFindViewById = view.getRootView().findFocus();
        }
        if (viewFindViewById == null) {
            viewFindViewById = view.getRootView().findViewById(R.id.content);
        }
        if (viewFindViewById == null || !viewFindViewById.hasWindowFocus()) {
            return;
        }
        viewFindViewById.post(new f0(viewFindViewById, 1));
    }

    @Override // mb.a
    public void a(nb.n nVar) {
        this.f7483w = nVar;
        if (Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", "Registered Firebase Analytics event receiver for breadcrumbs", null);
        }
    }

    @Override // o8.c
    public void b(l8.b bVar) {
        ((m8.d) this.f7483w).b(bVar);
    }

    @Override // n.v
    public void c(n.k kVar, boolean z10) {
        if (kVar instanceof n.c0) {
            ((n.c0) kVar).f8498z.k().c(false);
        }
        n.v vVar = ((o.k) this.f7483w).f9253z;
        if (vVar != null) {
            vVar.c(kVar, z10);
        }
    }

    @Override // t0.e
    public int d() {
        return ((ContentInfo) this.f7483w).getSource();
    }

    @Override // t0.e
    public ClipData e() {
        return ((ContentInfo) this.f7483w).getClip();
    }

    @Override // s2.b1
    public void f(c1 c1Var) {
        m2.l lVar = (m2.l) this.f7483w;
        lVar.L.f(lVar);
    }

    @Override // l2.z
    public byte[] g(UUID uuid, l2.r rVar) {
        return (byte[]) this.f7483w;
    }

    @Override // qd.a
    public Object get() {
        return new l7.a((Context) ((u0.d) this.f7483w).f12060v, new f9.b0(13), new f9.a0(13), 27);
    }

    @Override // of.h
    public of.o h() throws Throwable {
        of.s sVarB;
        IOException iOException = null;
        while (!((of.p) this.f7483w).f9844k.K) {
            try {
                sVarB = ((of.p) this.f7483w).b();
            } catch (IOException e9) {
                if (iOException == null) {
                    iOException = e9;
                } else {
                    ab.b.c(iOException, e9);
                }
                if (!((of.p) this.f7483w).a(null)) {
                    throw iOException;
                }
            }
            if (!sVarB.b()) {
                of.r rVarG = sVarB.g();
                if (rVarG.f9852b == null && rVarG.f9853c == null) {
                    rVarG = sVarB.d();
                }
                of.s sVar = rVarG.f9852b;
                Throwable th = rVarG.f9853c;
                if (th != null) {
                    throw th;
                }
                if (sVar != null) {
                    ((of.p) this.f7483w).f9849p.addFirst(sVar);
                }
            }
            return sVarB.e();
        }
        throw new IOException("Canceled");
    }

    @Override // v4.e1
    public int i() {
        v4.h0 h0Var = (v4.h0) this.f7483w;
        return h0Var.f13258n - h0Var.E();
    }

    @Override // z5.i
    public void j(String str, Map map) {
        PlayerActivity playerActivity = (PlayerActivity) this.f7483w;
        playerActivity.A(str, playerActivity.f1524i0, null, playerActivity.f1526k0, map);
    }

    @Override // of.h
    public of.p l() {
        return (of.p) this.f7483w;
    }

    @Override // v4.e1
    public int m(View view) {
        return (view.getLeft() - ((i0) view.getLayoutParams()).f13262b.left) - ((ViewGroup.MarginLayoutParams) ((i0) view.getLayoutParams())).leftMargin;
    }

    @Override // n.v
    public boolean n(n.k kVar) {
        o.k kVar2 = (o.k) this.f7483w;
        if (kVar == kVar2.f9251x) {
            return false;
        }
        kVar2.T = ((n.c0) kVar).A.f8544a;
        n.v vVar = kVar2.f9253z;
        if (vVar != null) {
            return vVar.n(kVar);
        }
        return false;
    }

    @Override // t7.a
    public Object o() {
        tb.c cVar = (tb.c) this.f7483w;
        return new z6.r((c7.d) cVar.f11983v, (c7.d) cVar.f11984w, (c7.d) cVar.f11985x, (c7.d) cVar.f11986y, (z6.n) cVar.f11987z, (z6.n) cVar.A, (l7.a) cVar.B);
    }

    @Override // v9.f
    public void p(ArrayList arrayList) {
        ChipGroup chipGroup = (ChipGroup) this.f7483w;
        if (chipGroup.C.f3562b) {
            chipGroup.getCheckedChipId();
            throw null;
        }
    }

    @Override // t0.h
    public boolean q(float f) {
        if (f == 0.0f) {
            return false;
        }
        C();
        ((NestedScrollView) this.f7483w).j((int) f);
        return true;
    }

    @Override // t0.e
    public int r() {
        return ((ContentInfo) this.f7483w).getFlags();
    }

    @Override // t0.e
    public ContentInfo s() {
        return (ContentInfo) this.f7483w;
    }

    @Override // v4.e1
    public View t(int i) {
        return ((v4.h0) this.f7483w).u(i);
    }

    public String toString() {
        switch (this.f7482v) {
            case 16:
                return "ContentInfoCompat{" + ((ContentInfo) this.f7483w) + "}";
            default:
                return super.toString();
        }
    }

    @Override // v4.e1
    public int u() {
        return ((v4.h0) this.f7483w).D();
    }

    @Override // v4.e1
    public int v(View view) {
        return view.getRight() + ((i0) view.getLayoutParams()).f13262b.right + ((ViewGroup.MarginLayoutParams) ((i0) view.getLayoutParams())).rightMargin;
    }

    @Override // l2.z
    public byte[] w(l2.t tVar) {
        throw new UnsupportedOperationException();
    }

    @Override // n.i
    public boolean x(n.k kVar, MenuItem menuItem) {
        x5.q qVar = (x5.q) ((b6.f) this.f7483w).f1803z;
        if (qVar == null) {
            return false;
        }
        x5.r rVar = qVar.f14374v;
        int itemId = menuItem.getItemId();
        if (itemId == q5.k.add_playlist_from_url) {
            vf.g.X(rVar.j(), "Enter Playlist Details", "Add", null, null, null, null, false, new x5.q(rVar), null);
            return true;
        }
        if (itemId == q5.k.iptv_playlist) {
            vf.g.X(rVar.j(), "Enter Playlist Details", "Add", null, null, null, null, true, new x5.q(rVar), null);
            return true;
        }
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.setType("*/*");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{"application/vnd.apple.mpegurl", "audio/x-mpegurl"});
        rVar.f14380x0.a(intent);
        return true;
    }

    @Override // t0.h
    public float z() {
        return -((NestedScrollView) this.f7483w).getVerticalScrollFactorCompat();
    }

    public /* synthetic */ i(int i, boolean z10) {
        this.f7482v = i;
    }

    public i(byte[] bArr) {
        this.f7482v = 2;
        bArr.getClass();
        this.f7483w = bArr;
    }

    public i(int i) {
        this.f7482v = i;
        switch (i) {
            case 18:
                if (Build.VERSION.SDK_INT >= 26) {
                    this.f7483w = new u0.g(this);
                } else {
                    this.f7483w = new u0.f(this);
                }
                break;
            case 25:
                this.f7483w = new CopyOnWriteArrayList();
                break;
            default:
                ge.i.e(TimeUnit.MINUTES, "timeUnit");
                nf.d dVar = nf.d.f9159l;
                ge.i.e(dVar, "taskRunner");
                this.f7483w = new x0(dVar);
                break;
        }
    }

    public i(TextView textView) {
        this.f7482v = 4;
        this.f7483w = new m1.g(textView);
    }

    public i(ContentInfo contentInfo) {
        this.f7482v = 16;
        contentInfo.getClass();
        this.f7483w = i2.a.m(contentInfo);
    }

    @Override // n.i
    public void y(n.k kVar) {
    }
}
