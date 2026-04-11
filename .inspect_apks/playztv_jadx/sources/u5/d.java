package u5;

import a2.p0;
import a2.r0;
import android.content.ClipDescription;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import android.view.MenuItem;
import android.view.Window;
import android.widget.TextView;
import androidx.fragment.app.k0;
import androidx.fragment.app.v;
import c2.g0;
import c2.k;
import c2.n;
import com.google.android.gms.internal.measurement.k4;
import com.playz.tv.activities.PlayerActivity;
import d2.h;
import g1.g;
import h.i0;
import h4.l;
import h4.m;
import h4.y;
import h4.z;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipInputStream;
import k8.b0;
import k8.c0;
import k8.u0;
import k8.x3;
import m.i;
import n.k1;
import nc.t;
import org.json.JSONException;
import org.json.JSONObject;
import p1.n0;
import q2.e;
import s1.u;
import t7.j;
import ub.o;
import w2.p;
import z0.a0;
import z0.f;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d implements e.b, f, n, h, k1, i, pc.i, e7.b, u0, n0.a, e, t7.d {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f12783u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Object f12784v;

    public /* synthetic */ d(int i, Object obj) {
        this.f12783u = i;
        this.f12784v = obj;
    }

    @Override // d2.h
    public long A(long j5, long j8) {
        return 1L;
    }

    @Override // z0.f
    public ne.b B() {
        return ((a0) this.f12784v).f14746w;
    }

    @Override // c2.n
    public void C(k kVar) {
        k4 k4Var = ((g0) this.f12784v).f2314c1;
        Handler handler = (Handler) k4Var.f3070u;
        if (handler != null) {
            handler.post(new c2.h(k4Var, kVar, 9));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void D(int i, int i10, p pVar) throws n0 {
        int i11;
        int i12;
        int i13;
        long j5;
        int i14;
        int i15;
        int i16;
        int i17;
        o3.d dVar = (o3.d) this.f12784v;
        o3.e eVar = dVar.f9304b;
        SparseArray sparseArray = dVar.f9306c;
        u uVar = dVar.f9315k;
        u uVar2 = dVar.i;
        int i18 = 1;
        int i19 = 0;
        if (i != 161 && i != 163) {
            if (i == 165) {
                if (dVar.J != 2) {
                    return;
                }
                o3.c cVar = (o3.c) sparseArray.get(dVar.P);
                int i20 = dVar.S;
                u uVar3 = dVar.f9320p;
                if (i20 != 4 || !"V_VP9".equals(cVar.f9274c)) {
                    pVar.m(i10);
                    return;
                } else {
                    uVar3.G(i10);
                    pVar.readFully(uVar3.f11709a, 0, i10);
                    return;
                }
            }
            if (i == 16877) {
                dVar.d(i);
                o3.c cVar2 = dVar.f9328x;
                int i21 = cVar2.f9278h;
                if (i21 != 1685485123 && i21 != 1685480259) {
                    pVar.m(i10);
                    return;
                }
                byte[] bArr = new byte[i10];
                cVar2.P = bArr;
                pVar.readFully(bArr, 0, i10);
                return;
            }
            if (i == 16981) {
                dVar.d(i);
                byte[] bArr2 = new byte[i10];
                dVar.f9328x.f9279j = bArr2;
                pVar.readFully(bArr2, 0, i10);
                return;
            }
            if (i == 18402) {
                byte[] bArr3 = new byte[i10];
                pVar.readFully(bArr3, 0, i10);
                dVar.d(i);
                dVar.f9328x.f9280k = new w2.g0(1, 0, 0, bArr3);
                return;
            }
            if (i == 21419) {
                Arrays.fill(uVar.f11709a, (byte) 0);
                pVar.readFully(uVar.f11709a, 4 - i10, i10);
                uVar.J(0);
                dVar.f9330z = (int) uVar.z();
                return;
            }
            if (i == 25506) {
                dVar.d(i);
                byte[] bArr4 = new byte[i10];
                dVar.f9328x.f9281l = bArr4;
                pVar.readFully(bArr4, 0, i10);
                return;
            }
            if (i != 30322) {
                throw n0.a(null, "Unexpected id: " + i);
            }
            dVar.d(i);
            byte[] bArr5 = new byte[i10];
            dVar.f9328x.f9293x = bArr5;
            pVar.readFully(bArr5, 0, i10);
            return;
        }
        if (dVar.J == 0) {
            dVar.P = (int) eVar.b(pVar, false, true, 8);
            dVar.Q = eVar.f9334c;
            dVar.L = -9223372036854775807L;
            dVar.J = 1;
            uVar2.G(0);
        }
        o3.c cVar3 = (o3.c) sparseArray.get(dVar.P);
        if (cVar3 == null) {
            pVar.m(i10 - dVar.Q);
            dVar.J = 0;
            return;
        }
        cVar3.Z.getClass();
        if (dVar.J == 1) {
            dVar.j(pVar, 3);
            int i22 = (uVar2.f11709a[2] & 6) >> 1;
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
                dVar.j(pVar, 4);
                int i24 = (uVar2.f11709a[3] & 255) + 1;
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
                            dVar.j(pVar, i31);
                            if (uVar2.f11709a[i29] == 0) {
                                throw n0.a(null, "No valid varint length mask found");
                            }
                            int i32 = i18;
                            int i33 = i19;
                            while (true) {
                                if (i33 >= 8) {
                                    i13 = i19;
                                    j5 = 0;
                                    i14 = i31;
                                    break;
                                }
                                int i34 = i32 << (7 - i33);
                                i13 = i19;
                                if ((uVar2.f11709a[i29] & i34) != 0) {
                                    i14 = i31 + i33;
                                    dVar.j(pVar, i14);
                                    j5 = uVar2.f11709a[i29] & i23 & (~i34);
                                    while (i31 < i14) {
                                        j5 = (j5 << 8) | ((long) (uVar2.f11709a[i31] & i23));
                                        i31++;
                                        i23 = 255;
                                    }
                                    if (i27 > 0) {
                                        j5 -= (1 << ((i33 * 7) + 6)) - 1;
                                    }
                                } else {
                                    i33++;
                                    i19 = i13;
                                    i23 = 255;
                                }
                            }
                            if (j5 < -2147483648L || j5 > 2147483647L) {
                                break;
                            }
                            int i35 = (int) j5;
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
                            dVar.j(pVar, i16);
                            int i39 = uVar2.f11709a[i38] & 255;
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
            byte[] bArr6 = uVar2.f11709a;
            dVar.K = dVar.m((bArr6[i11] & 255) | (bArr6[i12] << 8)) + dVar.E;
            dVar.R = (cVar3.f9276e == 2 || (i == 163 && (uVar2.f11709a[2] & 128) == 128)) ? i11 : i12;
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
                    dVar.h(cVar3, ((long) ((dVar.M * cVar3.f) / 1000)) + dVar.K, dVar.R, dVar.n(pVar, cVar3, dVar.O[i40], false), 0);
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
                boolean z2 = i11;
                iArr5[i41] = dVar.n(pVar, cVar3, iArr5[i41], z2);
                dVar.M += z2 ? 1 : 0;
            }
        }
    }

    @Override // c2.n
    public void E() {
        r0 r0Var = ((g0) this.f12784v).f6730b0;
        if (r0Var != null) {
            r0Var.a();
        }
    }

    @Override // c2.n
    public void F(int i, long j5, long j8) {
        k4 k4Var = ((g0) this.f12784v).f2314c1;
        Handler handler = (Handler) k4Var.f3070u;
        if (handler != null) {
            handler.post(new c2.h(k4Var, i, j5, j8));
        }
    }

    public synchronized void G() {
        try {
            long j5 = ((SharedPreferences) this.f12784v).getLong("fire-count", 0L);
            String key = "";
            String str = null;
            for (Map.Entry<String, ?> entry : ((SharedPreferences) this.f12784v).getAll().entrySet()) {
                if (entry.getValue() instanceof Set) {
                    for (String str2 : (Set) entry.getValue()) {
                        if (str == null || str.compareTo(str2) > 0) {
                            key = entry.getKey();
                            str = str2;
                        }
                    }
                }
            }
            HashSet hashSet = new HashSet(((SharedPreferences) this.f12784v).getStringSet(key, new HashSet()));
            hashSet.remove(str);
            ((SharedPreferences) this.f12784v).edit().putStringSet(key, hashSet).putLong("fire-count", j5 - 1).commit();
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void H() {
        try {
            SharedPreferences.Editor editorEdit = ((SharedPreferences) this.f12784v).edit();
            int i = 0;
            for (Map.Entry<String, ?> entry : ((SharedPreferences) this.f12784v).getAll().entrySet()) {
                if (entry.getValue() instanceof Set) {
                    Set set = (Set) entry.getValue();
                    String strL = L(System.currentTimeMillis());
                    String key = entry.getKey();
                    if (set.contains(strL)) {
                        HashSet hashSet = new HashSet();
                        hashSet.add(strL);
                        i++;
                        editorEdit.putStringSet(key, hashSet);
                    } else {
                        editorEdit.remove(key);
                    }
                }
            }
            if (i == 0) {
                editorEdit.remove("fire-count");
            } else {
                editorEdit.putLong("fire-count", i);
            }
            editorEdit.commit();
        } catch (Throwable th) {
            throw th;
        }
    }

    public String I(Object obj) {
        StringWriter stringWriter = new StringWriter();
        try {
            ib.d dVar = (ib.d) this.f12784v;
            ib.e eVar = new ib.e(stringWriter, dVar.f6478a, dVar.f6479b, dVar.f6480c, dVar.f6481d);
            eVar.h(obj);
            eVar.j();
            eVar.f6483b.flush();
        } catch (IOException unused) {
        }
        return stringWriter.toString();
    }

    public l5.a0 J(Context context, String str, InputStream inputStream, String str2, String str3) {
        l5.a0 a0VarF;
        b bVar;
        c cVar = (c) this.f12784v;
        if (str2 == null) {
            str2 = "application/json";
        }
        if (str2.contains("application/zip") || str2.contains("application/x-zip") || str2.contains("application/x-zip-compressed") || str.split("\\?")[0].endsWith(".lottie")) {
            x5.b.a();
            b bVar2 = b.f12777w;
            a0VarF = str3 != null ? l5.n.f(context, new ZipInputStream(new FileInputStream(cVar.p(str, inputStream, bVar2))), str) : l5.n.f(context, new ZipInputStream(inputStream), null);
            bVar = bVar2;
        } else if (str2.contains("application/gzip") || str2.contains("application/x-gzip") || str.split("\\?")[0].endsWith(".tgs")) {
            x5.b.a();
            bVar = b.f12778x;
            a0VarF = str3 != null ? l5.n.c(new GZIPInputStream(new FileInputStream(cVar.p(str, inputStream, bVar))), str) : l5.n.c(new GZIPInputStream(inputStream), null);
        } else {
            x5.b.a();
            bVar = b.f12776v;
            a0VarF = str3 != null ? l5.n.c(new FileInputStream(cVar.p(str, inputStream, bVar).getAbsolutePath()), str) : l5.n.c(inputStream, null);
        }
        if (str3 != null && a0VarF.f7823a != null) {
            File file = new File(cVar.l(), c.c(str, bVar, true));
            File file2 = new File(file.getAbsolutePath().replace(".temp", ""));
            boolean zRenameTo = file.renameTo(file2);
            file2.toString();
            x5.b.a();
            if (!zRenameTo) {
                x5.b.b("Unable to rename cache file " + file.getAbsolutePath() + " to " + file2.getAbsolutePath() + ".");
            }
        }
        return a0VarF;
    }

    public synchronized ArrayList K() {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            for (Map.Entry<String, ?> entry : ((SharedPreferences) this.f12784v).getAll().entrySet()) {
                if (entry.getValue() instanceof Set) {
                    HashSet hashSet = new HashSet((Set) entry.getValue());
                    hashSet.remove(L(System.currentTimeMillis()));
                    if (!hashSet.isEmpty()) {
                        arrayList.add(new lb.a(entry.getKey(), new ArrayList(hashSet)));
                    }
                }
            }
            W(System.currentTimeMillis());
        } catch (Throwable th) {
            throw th;
        }
        return arrayList;
    }

    public synchronized String L(long j5) {
        if (Build.VERSION.SDK_INT < 26) {
            return new SimpleDateFormat("yyyy-MM-dd", Locale.UK).format(new Date(j5));
        }
        Instant instant = new Date(j5).toInstant();
        ZoneOffset unused = ZoneOffset.UTC;
        LocalDateTime localDateTime = instant.atOffset(ZoneOffset.UTC).toLocalDateTime();
        DateTimeFormatter unused2 = DateTimeFormatter.ISO_LOCAL_DATE;
        return localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    public synchronized String M(String str) {
        for (Map.Entry<String, ?> entry : ((SharedPreferences) this.f12784v).getAll().entrySet()) {
            if (entry.getValue() instanceof Set) {
                Iterator it = ((Set) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (str.equals((String) it.next())) {
                        return entry.getKey();
                    }
                }
            }
        }
        return null;
    }

    public void N(int i, long j5) throws n0 {
        o3.d dVar = (o3.d) this.f12784v;
        if (i == 20529) {
            if (j5 == 0) {
                return;
            }
            throw n0.a(null, "ContentEncodingOrder " + j5 + " not supported");
        }
        if (i == 20530) {
            if (j5 == 1) {
                return;
            }
            throw n0.a(null, "ContentEncodingScope " + j5 + " not supported");
        }
        switch (i) {
            case 131:
                dVar.d(i);
                dVar.f9328x.f9276e = (int) j5;
                return;
            case 136:
                dVar.d(i);
                dVar.f9328x.X = j5 == 1;
                return;
            case 155:
                dVar.L = dVar.m(j5);
                return;
            case 159:
                dVar.d(i);
                dVar.f9328x.Q = (int) j5;
                return;
            case 176:
                dVar.d(i);
                dVar.f9328x.f9283n = (int) j5;
                return;
            case 179:
                dVar.b(i);
                dVar.F.a(dVar.m(j5));
                return;
            case 186:
                dVar.d(i);
                dVar.f9328x.f9284o = (int) j5;
                return;
            case 215:
                dVar.d(i);
                dVar.f9328x.f9275d = (int) j5;
                return;
            case 231:
                dVar.E = dVar.m(j5);
                return;
            case 238:
                dVar.S = (int) j5;
                return;
            case 241:
                if (dVar.H) {
                    return;
                }
                dVar.b(i);
                dVar.G.a(j5);
                dVar.H = true;
                return;
            case 251:
                dVar.T = true;
                return;
            case 16871:
                dVar.d(i);
                dVar.f9328x.f9278h = (int) j5;
                return;
            case 16980:
                if (j5 == 3) {
                    return;
                }
                throw n0.a(null, "ContentCompAlgo " + j5 + " not supported");
            case 17029:
                if (j5 < 1 || j5 > 2) {
                    throw n0.a(null, "DocTypeReadVersion " + j5 + " not supported");
                }
                return;
            case 17143:
                if (j5 == 1) {
                    return;
                }
                throw n0.a(null, "EBMLReadVersion " + j5 + " not supported");
            case 18401:
                if (j5 == 5) {
                    return;
                }
                throw n0.a(null, "ContentEncAlgo " + j5 + " not supported");
            case 18408:
                if (j5 == 1) {
                    return;
                }
                throw n0.a(null, "AESSettingsCipherMode " + j5 + " not supported");
            case 21420:
                dVar.A = j5 + dVar.f9323s;
                return;
            case 21432:
                int i10 = (int) j5;
                dVar.d(i);
                if (i10 == 0) {
                    dVar.f9328x.f9294y = 0;
                    return;
                }
                if (i10 == 1) {
                    dVar.f9328x.f9294y = 2;
                    return;
                } else if (i10 == 3) {
                    dVar.f9328x.f9294y = 1;
                    return;
                } else {
                    if (i10 != 15) {
                        return;
                    }
                    dVar.f9328x.f9294y = 3;
                    return;
                }
            case 21680:
                dVar.d(i);
                dVar.f9328x.f9286q = (int) j5;
                return;
            case 21682:
                dVar.d(i);
                dVar.f9328x.f9288s = (int) j5;
                return;
            case 21690:
                dVar.d(i);
                dVar.f9328x.f9287r = (int) j5;
                return;
            case 21930:
                dVar.d(i);
                dVar.f9328x.W = j5 == 1;
                return;
            case 21938:
                dVar.d(i);
                o3.c cVar = dVar.f9328x;
                cVar.f9295z = true;
                cVar.f9285p = (int) j5;
                return;
            case 21998:
                dVar.d(i);
                dVar.f9328x.f9277g = (int) j5;
                return;
            case 22186:
                dVar.d(i);
                dVar.f9328x.T = j5;
                return;
            case 22203:
                dVar.d(i);
                dVar.f9328x.U = j5;
                return;
            case 25188:
                dVar.d(i);
                dVar.f9328x.R = (int) j5;
                return;
            case 30114:
                dVar.U = j5;
                return;
            case 30321:
                dVar.d(i);
                int i11 = (int) j5;
                if (i11 == 0) {
                    dVar.f9328x.f9289t = 0;
                    return;
                }
                if (i11 == 1) {
                    dVar.f9328x.f9289t = 1;
                    return;
                } else if (i11 == 2) {
                    dVar.f9328x.f9289t = 2;
                    return;
                } else {
                    if (i11 != 3) {
                        return;
                    }
                    dVar.f9328x.f9289t = 3;
                    return;
                }
            case 2352003:
                dVar.d(i);
                dVar.f9328x.f = (int) j5;
                return;
            case 2807729:
                dVar.f9324t = j5;
                return;
            default:
                switch (i) {
                    case 21945:
                        dVar.d(i);
                        int i12 = (int) j5;
                        if (i12 == 1) {
                            dVar.f9328x.C = 2;
                            return;
                        } else {
                            if (i12 != 2) {
                                return;
                            }
                            dVar.f9328x.C = 1;
                            return;
                        }
                    case 21946:
                        dVar.d(i);
                        int iG = p1.h.g((int) j5);
                        if (iG != -1) {
                            dVar.f9328x.B = iG;
                            return;
                        }
                        return;
                    case 21947:
                        dVar.d(i);
                        dVar.f9328x.f9295z = true;
                        int iF = p1.h.f((int) j5);
                        if (iF != -1) {
                            dVar.f9328x.A = iF;
                            return;
                        }
                        return;
                    case 21948:
                        dVar.d(i);
                        dVar.f9328x.D = (int) j5;
                        return;
                    case 21949:
                        dVar.d(i);
                        dVar.f9328x.E = (int) j5;
                        return;
                    default:
                        return;
                }
        }
    }

    public synchronized boolean O(long j5, long j8) {
        return L(j5).equals(L(j8));
    }

    public bb.c Q(JSONObject jSONObject) throws JSONException {
        bb.e jVar;
        int i = jSONObject.getInt("settings_version");
        if (i != 3) {
            Log.e("FirebaseCrashlytics", "Could not determine SettingsJsonTransform for settings version " + i + ". Using default settings values.", null);
            jVar = new q9.e(4);
        } else {
            jVar = new j(4);
        }
        return jVar.b((c0) this.f12784v, jSONObject);
    }

    public synchronized void R() {
        String strL = L(System.currentTimeMillis());
        ((SharedPreferences) this.f12784v).edit().putString("last-used-date", strL).commit();
        S(strL);
    }

    public synchronized void S(String str) {
        try {
            String strM = M(str);
            if (strM == null) {
                return;
            }
            HashSet hashSet = new HashSet(((SharedPreferences) this.f12784v).getStringSet(strM, new HashSet()));
            hashSet.remove(str);
            if (hashSet.isEmpty()) {
                ((SharedPreferences) this.f12784v).edit().remove(strM).commit();
            } else {
                ((SharedPreferences) this.f12784v).edit().putStringSet(strM, hashSet).commit();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized boolean T(long j5) {
        return U(j5);
    }

    public synchronized boolean U(long j5) {
        if (!((SharedPreferences) this.f12784v).contains("fire-global")) {
            ((SharedPreferences) this.f12784v).edit().putLong("fire-global", j5).commit();
            return true;
        }
        if (O(((SharedPreferences) this.f12784v).getLong("fire-global", -1L), j5)) {
            return false;
        }
        ((SharedPreferences) this.f12784v).edit().putLong("fire-global", j5).commit();
        return true;
    }

    public synchronized void V(String str, long j5) {
        String strL = L(j5);
        if (((SharedPreferences) this.f12784v).getString("last-used-date", "").equals(strL)) {
            String strM = M(strL);
            if (strM == null) {
                return;
            }
            if (strM.equals(str)) {
                return;
            }
            X(str, strL);
            return;
        }
        long j8 = ((SharedPreferences) this.f12784v).getLong("fire-count", 0L);
        if (j8 + 1 == 30) {
            G();
            j8 = ((SharedPreferences) this.f12784v).getLong("fire-count", 0L);
        }
        HashSet hashSet = new HashSet(((SharedPreferences) this.f12784v).getStringSet(str, new HashSet()));
        hashSet.add(strL);
        ((SharedPreferences) this.f12784v).edit().putStringSet(str, hashSet).putLong("fire-count", j8 + 1).putString("last-used-date", strL).commit();
    }

    public synchronized void W(long j5) {
        ((SharedPreferences) this.f12784v).edit().putLong("fire-global", j5).commit();
    }

    public synchronized void X(String str, String str2) {
        S(str2);
        HashSet hashSet = new HashSet(((SharedPreferences) this.f12784v).getStringSet(str, new HashSet()));
        hashSet.add(str2);
        ((SharedPreferences) this.f12784v).edit().putStringSet(str, hashSet).commit();
    }

    @Override // c2.n
    public void a(boolean z2) {
        k4 k4Var = ((g0) this.f12784v).f2314c1;
        Handler handler = (Handler) k4Var.f3070u;
        if (handler != null) {
            handler.post(new c2.i(k4Var, z2));
        }
    }

    @Override // d2.h
    public long b(long j5) {
        return 0L;
    }

    @Override // d2.h
    public long c(long j5, long j8) {
        return 0L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // n0.a
    public void close() throws Exception {
        ContentProviderClient contentProviderClient = (ContentProviderClient) this.f12784v;
        if (contentProviderClient != 0) {
            if (contentProviderClient instanceof AutoCloseable) {
                contentProviderClient.close();
            } else if (contentProviderClient instanceof ExecutorService) {
                aa.c0.x((ExecutorService) contentProviderClient);
            } else {
                contentProviderClient.release();
            }
        }
    }

    @Override // c2.n
    public void e(int i) {
        a7.b bVar;
        g0 g0Var = (g0) this.f12784v;
        if (Build.VERSION.SDK_INT >= 35 && (bVar = g0Var.f2316e1) != null) {
            bVar.D(i);
        }
        k4 k4Var = g0Var.f2314c1;
        Handler handler = (Handler) k4Var.f3070u;
        if (handler != null) {
            handler.post(new p0(i, 1, k4Var));
        }
    }

    @Override // c2.n
    public void f(long j5) {
        k4 k4Var = ((g0) this.f12784v).f2314c1;
        Handler handler = (Handler) k4Var.f3070u;
        if (handler != null) {
            handler.post(new c2.h(k4Var, j5));
        }
    }

    @Override // m.i
    public boolean g(m.k kVar, MenuItem menuItem) {
        switch (this.f12783u) {
            case 14:
                break;
            default:
                t tVar = (t) ((o) this.f12784v).f12871y;
                if (tVar != null) {
                    nc.u uVar = tVar.f8970u;
                    int itemId = menuItem.getItemId();
                    if (itemId == gc.j.add_playlist_from_url) {
                        com.bumptech.glide.d.R(uVar.j(), "Enter Playlist Details", "Add", null, null, null, null, false, new t(uVar), null);
                    } else if (itemId == gc.j.iptv_playlist) {
                        com.bumptech.glide.d.R(uVar.j(), "Enter Playlist Details", "Add", null, null, null, null, true, new t(uVar), null);
                    } else {
                        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
                        intent.setType("*/*");
                        intent.addCategory("android.intent.category.OPENABLE");
                        intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{"application/vnd.apple.mpegurl", "audio/x-mpegurl"});
                        uVar.f8976w0.a(intent);
                    }
                }
                break;
        }
        return false;
    }

    @Override // md.a
    public Object get() {
        String packageName = ((Context) ((md.a) this.f12784v).get()).getPackageName();
        if (packageName != null) {
            return packageName;
        }
        throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // n0.a
    public Cursor h(Uri uri, String[] strArr, String[] strArr2) {
        ContentProviderClient contentProviderClient = (ContentProviderClient) this.f12784v;
        if (contentProviderClient == null) {
            return null;
        }
        try {
            return contentProviderClient.query(uri, strArr, "query = ?", strArr2, null, null);
        } catch (RemoteException e10) {
            Log.w("FontsProvider", "Unable to query the content provider", e10);
            return null;
        }
    }

    @Override // c2.n
    public void i() {
        r2.p pVar;
        g0 g0Var = (g0) this.f12784v;
        synchronized (g0Var.f231u) {
            pVar = g0Var.L;
        }
        if (pVar != null) {
            pVar.h();
        }
    }

    @Override // e.b
    public void j(Object obj) {
        e.a aVar = (e.a) obj;
        androidx.fragment.app.n0 n0Var = (androidx.fragment.app.n0) this.f12784v;
        k0 k0Var = (k0) n0Var.C.pollFirst();
        if (k0Var == null) {
            Log.w("FragmentManager", "No IntentSenders were started for " + this);
            return;
        }
        String str = k0Var.f1294u;
        int i = k0Var.f1295v;
        v vVarO = n0Var.f1312c.o(str);
        if (vVarO != null) {
            vVarO.t(i, aVar.f4213u, aVar.f4214v);
            return;
        }
        Log.w("FragmentManager", "Intent Sender result delivered for unknown Fragment " + str);
    }

    @Override // k8.u0
    public void k(String str, int i, Throwable th, byte[] bArr, Map map) {
        ((x3) this.f12784v).J(str, i, th, bArr, map);
    }

    @Override // pc.i
    public void l(String str, Map map) {
        PlayerActivity playerActivity = (PlayerActivity) this.f12784v;
        playerActivity.A(str, playerActivity.f3629h0, null, playerActivity.f3631j0, map);
    }

    @Override // t7.d
    public void m(q7.b bVar) {
        t7.e eVar = (t7.e) this.f12784v;
        if (bVar.f11028v == 0) {
            eVar.a(null, eVar.t());
            return;
        }
        t7.c cVar = eVar.f12279p;
        if (cVar != null) {
            cVar.c(bVar);
        }
    }

    @Override // c2.n
    public void n() {
        ((g0) this.f12784v).f2325n1 = true;
    }

    @Override // c2.n
    public void o(Exception exc) {
        s1.b.h("MediaCodecAudioRenderer", "Audio sink error", exc);
        k4 k4Var = ((g0) this.f12784v).f2314c1;
        Handler handler = (Handler) k4Var.f3070u;
        if (handler != null) {
            handler.post(new c2.h(k4Var, exc, 5));
        }
    }

    @Override // d2.h
    public long p(long j5, long j8) {
        return 0L;
    }

    @Override // c2.n
    public void q(k kVar) {
        k4 k4Var = ((g0) this.f12784v).f2314c1;
        Handler handler = (Handler) k4Var.f3070u;
        if (handler != null) {
            handler.post(new c2.h(k4Var, kVar, 1));
        }
    }

    @Override // z0.f
    public Object r(ae.p pVar, td.c cVar) {
        return ((a0) this.f12784v).r(new c1.c(pVar, null, 0), cVar);
    }

    @Override // m.i
    public void s(m.k kVar) {
        switch (this.f12783u) {
            case 14:
                i0 i0Var = (i0) this.f12784v;
                Window.Callback callback = i0Var.f5503d;
                if (i0Var.f5502c.f8443a.p()) {
                    callback.onPanelClosed(108, kVar);
                } else if (callback.onPreparePanel(0, null, kVar)) {
                    callback.onMenuOpened(108, kVar);
                }
                break;
        }
    }

    @Override // c2.n
    public void t() {
        ((g0) this.f12784v).f2323l1 = true;
    }

    @Override // d2.h
    public long u(long j5, long j8) {
        return -9223372036854775807L;
    }

    @Override // d2.h
    public e2.j v(long j5) {
        return (e2.j) this.f12784v;
    }

    @Override // c2.n
    public void w() {
        r0 r0Var = ((g0) this.f12784v).f6730b0;
        if (r0Var != null) {
            r0Var.f392a.l0 = true;
        }
    }

    @Override // d2.h
    public boolean x() {
        return true;
    }

    @Override // d2.h
    public long y() {
        return 0L;
    }

    @Override // d2.h
    public long z(long j5) {
        return 1L;
    }

    public /* synthetic */ d(int i, boolean z2) {
        this.f12783u = i;
    }

    public d(c cVar, k8.a0 a0Var) {
        this.f12783u = 0;
        this.f12784v = cVar;
    }

    public d(int i) {
        this.f12783u = i;
        switch (i) {
            case 11:
                this.f12784v = new SparseArray();
                break;
            case 27:
                this.f12784v = new b0(27);
                break;
            default:
                this.f12784v = new HashMap();
                break;
        }
    }

    public d(Context context, String str) {
        this.f12783u = 21;
        this.f12784v = context.getSharedPreferences("FirebaseHeartBeat" + str, 0);
    }

    public d(TextView textView) {
        this.f12783u = 10;
        this.f12784v = new g(textView);
    }

    public d(Uri uri, ClipDescription clipDescription, Uri uri2) {
        this.f12783u = 28;
        if (Build.VERSION.SDK_INT >= 25) {
            this.f12784v = new s0.f(uri, clipDescription, uri2);
        } else {
            this.f12784v = new kc.b(uri, clipDescription, uri2, 14);
        }
    }

    public d(Context context, Uri uri) {
        this.f12783u = 23;
        this.f12784v = context.getContentResolver().acquireUnstableContentProviderClient(uri);
    }

    public d(Context context, z zVar) {
        this.f12783u = 15;
        y yVar = ((h4.t) zVar.f5867v).f5849c;
        Collections.synchronizedSet(new HashSet());
        if (Build.VERSION.SDK_INT >= 29) {
            this.f12784v = new m(context, yVar);
        } else {
            this.f12784v = new l(context, yVar);
        }
    }

    private final void P(m.k kVar) {
    }

    @Override // d2.h
    public long d(long j5, long j8) {
        return j8;
    }
}
