package k8;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.i5;
import com.google.android.gms.internal.measurement.r5;
import com.google.android.gms.internal.measurement.x5;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d1 extends t3 implements f {
    public final s.e A;
    public final s.e B;
    public final s.e C;
    public final s.e D;
    public final e1 E;
    public final rc.b F;
    public final s.e G;
    public final s.e H;
    public final s.e I;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final s.e f7134y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final s.e f7135z;

    public d1(x3 x3Var) {
        super(x3Var);
        this.f7134y = new s.e(0);
        this.f7135z = new s.e(0);
        this.A = new s.e(0);
        this.B = new s.e(0);
        this.C = new s.e(0);
        this.G = new s.e(0);
        this.H = new s.e(0);
        this.I = new s.e(0);
        this.D = new s.e(0);
        this.E = new e1(this);
        this.F = new rc.b(18, this);
    }

    public static s.e A1(com.google.android.gms.internal.measurement.n2 n2Var) {
        s.e eVar = new s.e(0);
        for (com.google.android.gms.internal.measurement.r2 r2Var : n2Var.C()) {
            eVar.put(r2Var.n(), r2Var.o());
        }
        return eVar;
    }

    public static y1 y1(int i) {
        int i10 = g1.f7210b[v.e.c(i)];
        if (i10 == 1) {
            return y1.f7554v;
        }
        if (i10 == 2) {
            return y1.f7555w;
        }
        if (i10 == 3) {
            return y1.f7556x;
        }
        if (i10 != 4) {
            return null;
        }
        return y1.f7557y;
    }

    @Override // k8.f
    public final String B(String str, String str2) {
        p1();
        N1(str);
        Map map = (Map) this.f7134y.get(str);
        if (map != null) {
            return (String) map.get(str2);
        }
        return null;
    }

    public final void B1(String str, com.google.android.gms.internal.measurement.m2 m2Var) {
        HashSet hashSet = new HashSet();
        s.e eVar = new s.e(0);
        s.e eVar2 = new s.e(0);
        s.e eVar3 = new s.e(0);
        Iterator it = Collections.unmodifiableList(((com.google.android.gms.internal.measurement.n2) m2Var.f3052v).A()).iterator();
        while (it.hasNext()) {
            hashSet.add(((com.google.android.gms.internal.measurement.j2) it.next()).n());
        }
        for (int i = 0; i < ((com.google.android.gms.internal.measurement.n2) m2Var.f3052v).r(); i++) {
            com.google.android.gms.internal.measurement.k2 k2Var = (com.google.android.gms.internal.measurement.k2) ((com.google.android.gms.internal.measurement.n2) m2Var.f3052v).o(i).k();
            if (k2Var.g().isEmpty()) {
                g().D.d("EventConfig contained null event name");
            } else {
                String strG = k2Var.g();
                String strC = c2.c(k2Var.g(), c2.f7110a, c2.f7112c);
                if (!TextUtils.isEmpty(strC)) {
                    k2Var.e();
                    com.google.android.gms.internal.measurement.l2.o((com.google.android.gms.internal.measurement.l2) k2Var.f3052v, strC);
                    m2Var.e();
                    com.google.android.gms.internal.measurement.n2.q((com.google.android.gms.internal.measurement.n2) m2Var.f3052v, i, (com.google.android.gms.internal.measurement.l2) k2Var.c());
                }
                if (((com.google.android.gms.internal.measurement.l2) k2Var.f3052v).s() && ((com.google.android.gms.internal.measurement.l2) k2Var.f3052v).q()) {
                    eVar.put(strG, Boolean.TRUE);
                }
                if (((com.google.android.gms.internal.measurement.l2) k2Var.f3052v).t() && ((com.google.android.gms.internal.measurement.l2) k2Var.f3052v).r()) {
                    eVar2.put(k2Var.g(), Boolean.TRUE);
                }
                if (((com.google.android.gms.internal.measurement.l2) k2Var.f3052v).u()) {
                    if (((com.google.android.gms.internal.measurement.l2) k2Var.f3052v).n() < 2 || ((com.google.android.gms.internal.measurement.l2) k2Var.f3052v).n() > 65535) {
                        g().D.b(k2Var.g(), Integer.valueOf(((com.google.android.gms.internal.measurement.l2) k2Var.f3052v).n()), "Invalid sampling rate. Event name, sample rate");
                    } else {
                        eVar3.put(k2Var.g(), Integer.valueOf(((com.google.android.gms.internal.measurement.l2) k2Var.f3052v).n()));
                    }
                }
            }
        }
        this.f7135z.put(str, hashSet);
        this.A.put(str, eVar);
        this.B.put(str, eVar2);
        this.D.put(str, eVar3);
    }

    public final void C1(String str, com.google.android.gms.internal.measurement.n2 n2Var) {
        if (n2Var.n() == 0) {
            e1 e1Var = this.E;
            e1Var.getClass();
            be.h.e(str, "key");
            synchronized (((b0) e1Var.f10786g)) {
                t.b bVar = (t.b) e1Var.f;
                bVar.getClass();
                Object objRemove = bVar.f11962a.remove(str);
                if (objRemove != null) {
                    int i = e1Var.f10783c;
                    q4.e1.l(str, objRemove);
                    e1Var.f10783c = i - 1;
                }
            }
            return;
        }
        g().I.c(Integer.valueOf(n2Var.n()), "EES programs found");
        com.google.android.gms.internal.measurement.x3 x3Var = (com.google.android.gms.internal.measurement.x3) n2Var.B().get(0);
        try {
            com.google.android.gms.internal.measurement.v vVar = new com.google.android.gms.internal.measurement.v();
            c1 c1Var = new c1(2);
            c1Var.f7108b = this;
            c1Var.f7109c = str;
            ((HashMap) ((x5) vVar.f3213a.f12871y).f3235a).put("internal.remoteConfig", c1Var);
            c1 c1Var2 = new c1(1);
            c1Var2.f7108b = this;
            c1Var2.f7109c = str;
            ((HashMap) ((x5) vVar.f3213a.f12871y).f3235a).put("internal.appMetadata", c1Var2);
            f1 f1Var = new f1();
            f1Var.f7175b = this;
            ((HashMap) ((x5) vVar.f3213a.f12871y).f3235a).put("internal.logger", f1Var);
            vVar.a(x3Var);
            this.E.k(str, vVar);
            g().I.b(str, Integer.valueOf(x3Var.n().n()), "EES program loaded for appId, activities");
            Iterator it = x3Var.n().p().iterator();
            while (it.hasNext()) {
                g().I.c(((com.google.android.gms.internal.measurement.w3) it.next()).n(), "EES program activity");
            }
        } catch (com.google.android.gms.internal.measurement.l0 unused) {
            g().A.c(str, "Failed to load EES program. appId");
        }
    }

    public final void D1(String str, String str2, String str3, byte[] bArr) {
        byte[] bArrC;
        boolean z2;
        boolean z10;
        t1();
        p1();
        t7.v.d(str);
        com.google.android.gms.internal.measurement.m2 m2Var = (com.google.android.gms.internal.measurement.m2) x1(str, bArr).k();
        B1(str, m2Var);
        C1(str, (com.google.android.gms.internal.measurement.n2) m2Var.c());
        com.google.android.gms.internal.measurement.n2 n2Var = (com.google.android.gms.internal.measurement.n2) m2Var.c();
        s.e eVar = this.C;
        eVar.put(str, n2Var);
        this.G.put(str, ((com.google.android.gms.internal.measurement.n2) m2Var.f3052v).y());
        this.H.put(str, str2);
        this.I.put(str, str3);
        this.f7134y.put(str, A1((com.google.android.gms.internal.measurement.n2) m2Var.c()));
        i iVarR1 = r1();
        ArrayList arrayList = new ArrayList(Collections.unmodifiableList(((com.google.android.gms.internal.measurement.n2) m2Var.f3052v).z()));
        int i = 0;
        while (i < arrayList.size()) {
            com.google.android.gms.internal.measurement.t1 t1Var = (com.google.android.gms.internal.measurement.t1) ((com.google.android.gms.internal.measurement.u1) arrayList.get(i)).k();
            if (((com.google.android.gms.internal.measurement.u1) t1Var.f3052v).r() != 0) {
                int i10 = 0;
                while (i10 < ((com.google.android.gms.internal.measurement.u1) t1Var.f3052v).r()) {
                    com.google.android.gms.internal.measurement.v1 v1Var = (com.google.android.gms.internal.measurement.v1) ((com.google.android.gms.internal.measurement.u1) t1Var.f3052v).o(i10).k();
                    com.google.android.gms.internal.measurement.v1 v1Var2 = (com.google.android.gms.internal.measurement.v1) ((i5) v1Var.clone());
                    s.e eVar2 = eVar;
                    String strC = c2.c(((com.google.android.gms.internal.measurement.w1) v1Var.f3052v).u(), c2.f7110a, c2.f7112c);
                    if (strC != null) {
                        v1Var2.e();
                        com.google.android.gms.internal.measurement.w1.q((com.google.android.gms.internal.measurement.w1) v1Var2.f3052v, strC);
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    int i11 = 0;
                    while (i11 < ((com.google.android.gms.internal.measurement.w1) v1Var.f3052v).n()) {
                        com.google.android.gms.internal.measurement.y1 y1VarO = ((com.google.android.gms.internal.measurement.w1) v1Var.f3052v).o(i11);
                        com.google.android.gms.internal.measurement.v1 v1Var3 = v1Var;
                        boolean z11 = z10;
                        String strC2 = c2.c(y1VarO.r(), c2.f7115g, c2.f7116h);
                        if (strC2 != null) {
                            com.google.android.gms.internal.measurement.x1 x1Var = (com.google.android.gms.internal.measurement.x1) y1VarO.k();
                            x1Var.e();
                            com.google.android.gms.internal.measurement.y1.n((com.google.android.gms.internal.measurement.y1) x1Var.f3052v, strC2);
                            com.google.android.gms.internal.measurement.y1 y1Var = (com.google.android.gms.internal.measurement.y1) x1Var.c();
                            v1Var2.e();
                            com.google.android.gms.internal.measurement.w1.p((com.google.android.gms.internal.measurement.w1) v1Var2.f3052v, i11, y1Var);
                            z10 = true;
                        } else {
                            z10 = z11;
                        }
                        i11++;
                        v1Var = v1Var3;
                    }
                    if (z10) {
                        t1Var.e();
                        com.google.android.gms.internal.measurement.u1.p((com.google.android.gms.internal.measurement.u1) t1Var.f3052v, i10, (com.google.android.gms.internal.measurement.w1) v1Var2.c());
                        arrayList.set(i, (com.google.android.gms.internal.measurement.u1) t1Var.c());
                    }
                    i10++;
                    eVar = eVar2;
                }
            }
            s.e eVar3 = eVar;
            if (((com.google.android.gms.internal.measurement.u1) t1Var.f3052v).t() != 0) {
                for (int i12 = 0; i12 < ((com.google.android.gms.internal.measurement.u1) t1Var.f3052v).t(); i12++) {
                    com.google.android.gms.internal.measurement.c2 c2VarS = ((com.google.android.gms.internal.measurement.u1) t1Var.f3052v).s(i12);
                    String strC3 = c2.c(c2VarS.r(), c2.f7114e, c2.f);
                    if (strC3 != null) {
                        com.google.android.gms.internal.measurement.b2 b2Var = (com.google.android.gms.internal.measurement.b2) c2VarS.k();
                        b2Var.e();
                        com.google.android.gms.internal.measurement.c2.o((com.google.android.gms.internal.measurement.c2) b2Var.f3052v, strC3);
                        t1Var.e();
                        com.google.android.gms.internal.measurement.u1.q((com.google.android.gms.internal.measurement.u1) t1Var.f3052v, i12, (com.google.android.gms.internal.measurement.c2) b2Var.c());
                        arrayList.set(i, (com.google.android.gms.internal.measurement.u1) t1Var.c());
                    }
                }
            }
            i++;
            eVar = eVar3;
        }
        s.e eVar4 = eVar;
        iVarR1.t1();
        iVarR1.p1();
        t7.v.d(str);
        SQLiteDatabase sQLiteDatabaseW1 = iVarR1.w1();
        sQLiteDatabaseW1.beginTransaction();
        try {
            iVarR1.t1();
            iVarR1.p1();
            t7.v.d(str);
            SQLiteDatabase sQLiteDatabaseW12 = iVarR1.w1();
            sQLiteDatabaseW12.delete("property_filters", "app_id=?", new String[]{str});
            sQLiteDatabaseW12.delete("event_filters", "app_id=?", new String[]{str});
            int size = arrayList.size();
            int i13 = 0;
            while (i13 < size) {
                Object obj = arrayList.get(i13);
                i13++;
                com.google.android.gms.internal.measurement.u1 u1Var = (com.google.android.gms.internal.measurement.u1) obj;
                iVarR1.t1();
                iVarR1.p1();
                t7.v.d(str);
                t7.v.h(u1Var);
                if (u1Var.w()) {
                    int iN = u1Var.n();
                    Iterator it = u1Var.u().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (!((com.google.android.gms.internal.measurement.w1) it.next()).A()) {
                                iVarR1.g().D.b(p0.v1(str), Integer.valueOf(iN), "Event filter with no ID. Audience definition ignored. appId, audienceId");
                                break;
                            }
                        } else {
                            Iterator it2 = u1Var.v().iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    if (!((com.google.android.gms.internal.measurement.c2) it2.next()).v()) {
                                        iVarR1.g().D.b(p0.v1(str), Integer.valueOf(iN), "Property filter with no ID. Audience definition ignored. appId, audienceId");
                                        break;
                                    }
                                } else {
                                    Iterator it3 = u1Var.u().iterator();
                                    while (true) {
                                        if (it3.hasNext()) {
                                            if (!iVarR1.X1(str, iN, (com.google.android.gms.internal.measurement.w1) it3.next())) {
                                                z2 = false;
                                                break;
                                            }
                                        } else {
                                            z2 = true;
                                            break;
                                        }
                                    }
                                    if (z2) {
                                        Iterator it4 = u1Var.v().iterator();
                                        while (true) {
                                            if (it4.hasNext()) {
                                                if (!iVarR1.Y1(str, iN, (com.google.android.gms.internal.measurement.c2) it4.next())) {
                                                    z2 = false;
                                                    break;
                                                }
                                            } else {
                                                break;
                                            }
                                        }
                                    }
                                    if (!z2) {
                                        iVarR1.t1();
                                        iVarR1.p1();
                                        t7.v.d(str);
                                        SQLiteDatabase sQLiteDatabaseW13 = iVarR1.w1();
                                        sQLiteDatabaseW13.delete("property_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(iN)});
                                        sQLiteDatabaseW13.delete("event_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(iN)});
                                    }
                                }
                            }
                        }
                    }
                } else {
                    iVarR1.g().D.c(p0.v1(str), "Audience with no ID. appId");
                }
            }
            ArrayList arrayList2 = new ArrayList();
            int size2 = arrayList.size();
            int i14 = 0;
            while (i14 < size2) {
                Object obj2 = arrayList.get(i14);
                i14++;
                com.google.android.gms.internal.measurement.u1 u1Var2 = (com.google.android.gms.internal.measurement.u1) obj2;
                arrayList2.add(u1Var2.w() ? Integer.valueOf(u1Var2.n()) : null);
            }
            iVarR1.h2(str, arrayList2);
            sQLiteDatabaseW1.setTransactionSuccessful();
            sQLiteDatabaseW1.endTransaction();
            try {
                m2Var.e();
                com.google.android.gms.internal.measurement.n2.p((com.google.android.gms.internal.measurement.n2) m2Var.f3052v);
                bArrC = ((com.google.android.gms.internal.measurement.n2) m2Var.c()).c();
            } catch (RuntimeException e10) {
                g().D.b(p0.v1(str), e10, "Unable to serialize reduced-size config. Storing full config instead. appId");
                bArrC = bArr;
            }
            i iVarR12 = r1();
            t7.v.d(str);
            iVarR12.p1();
            iVarR12.t1();
            ContentValues contentValues = new ContentValues();
            contentValues.put("remote_config", bArrC);
            contentValues.put("config_last_modified_time", str2);
            contentValues.put("e_tag", str3);
            try {
                if (iVarR12.w1().update("apps", contentValues, "app_id = ?", new String[]{str}) == 0) {
                    iVarR12.g().A.c(p0.v1(str), "Failed to update remote config (got 0). appId");
                }
            } catch (SQLiteException e11) {
                iVarR12.g().A.b(p0.v1(str), e11, "Error storing remote config. appId");
            }
            eVar4.put(str, (com.google.android.gms.internal.measurement.n2) m2Var.c());
        } catch (Throwable th) {
            sQLiteDatabaseW1.endTransaction();
            throw th;
        }
    }

    public final int E1(String str, String str2) {
        Integer num;
        p1();
        N1(str);
        Map map = (Map) this.D.get(str);
        if (map == null || (num = (Integer) map.get(str2)) == null) {
            return 1;
        }
        return num.intValue();
    }

    public final com.google.android.gms.internal.measurement.i2 F1(String str) {
        p1();
        N1(str);
        com.google.android.gms.internal.measurement.n2 n2VarG1 = G1(str);
        if (n2VarG1 == null || !n2VarG1.D()) {
            return null;
        }
        return n2VarG1.t();
    }

    public final com.google.android.gms.internal.measurement.n2 G1(String str) {
        t1();
        p1();
        t7.v.d(str);
        N1(str);
        return (com.google.android.gms.internal.measurement.n2) this.C.get(str);
    }

    public final boolean H1(String str, String str2) {
        Boolean bool;
        p1();
        N1(str);
        if ("ecommerce_purchase".equals(str2) || "purchase".equals(str2) || "refund".equals(str2)) {
            return true;
        }
        Map map = (Map) this.B.get(str);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final boolean I1(String str, y1 y1Var) {
        p1();
        N1(str);
        com.google.android.gms.internal.measurement.i2 i2VarF1 = F1(str);
        if (i2VarF1 == null) {
            return false;
        }
        for (com.google.android.gms.internal.measurement.f2 f2Var : i2VarF1.p()) {
            if (y1Var == y1(f2Var.o())) {
                return f2Var.n() == 2;
            }
        }
        return false;
    }

    public final boolean J1(String str, String str2) {
        Boolean bool;
        p1();
        N1(str);
        if ("1".equals(B(str, "measurement.upload.blacklist_internal")) && h4.u2(str2)) {
            return true;
        }
        if ("1".equals(B(str, "measurement.upload.blacklist_public")) && h4.v2(str2)) {
            return true;
        }
        Map map = (Map) this.A.get(str);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final String K1(String str) {
        p1();
        N1(str);
        return (String) this.G.get(str);
    }

    public final boolean L1(String str) {
        p1();
        N1(str);
        s.e eVar = this.f7135z;
        return eVar.get(str) != null && ((Set) eVar.get(str)).contains("app_instance_id");
    }

    public final boolean M1(String str) {
        p1();
        N1(str);
        s.e eVar = this.f7135z;
        if (eVar.get(str) != null) {
            return ((Set) eVar.get(str)).contains("os_version") || ((Set) eVar.get(str)).contains("device_info");
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void N1(java.lang.String r13) {
        /*
            Method dump skipped, instruction units count: 284
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k8.d1.N1(java.lang.String):void");
    }

    @Override // k8.t3
    public final boolean v1() {
        return false;
    }

    public final long w1(String str) {
        String strB = B(str, "measurement.account.time_zone_offset_minutes");
        if (TextUtils.isEmpty(strB)) {
            return 0L;
        }
        try {
            return Long.parseLong(strB);
        } catch (NumberFormatException e10) {
            g().D.b(p0.v1(str), e10, "Unable to parse timezone offset. appId");
            return 0L;
        }
    }

    public final com.google.android.gms.internal.measurement.n2 x1(String str, byte[] bArr) {
        if (bArr == null) {
            return com.google.android.gms.internal.measurement.n2.v();
        }
        try {
            com.google.android.gms.internal.measurement.n2 n2Var = (com.google.android.gms.internal.measurement.n2) ((com.google.android.gms.internal.measurement.m2) s0.D1(com.google.android.gms.internal.measurement.n2.u(), bArr)).c();
            g().I.b(n2Var.G() ? Long.valueOf(n2Var.s()) : null, n2Var.E() ? n2Var.x() : null, "Parsed config. version, gmp_app_id");
            return n2Var;
        } catch (r5 e10) {
            g().D.b(p0.v1(str), e10, "Unable to merge remote config. appId");
            return com.google.android.gms.internal.measurement.n2.v();
        } catch (RuntimeException e11) {
            g().D.b(p0.v1(str), e11, "Unable to merge remote config. appId");
            return com.google.android.gms.internal.measurement.n2.v();
        }
    }

    public final b2 z1(String str, y1 y1Var) {
        p1();
        N1(str);
        com.google.android.gms.internal.measurement.i2 i2VarF1 = F1(str);
        if (i2VarF1 != null) {
            Iterator it = i2VarF1.r().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.google.android.gms.internal.measurement.f2 f2Var = (com.google.android.gms.internal.measurement.f2) it.next();
                if (y1(f2Var.o()) == y1Var) {
                    int i = g1.f7211c[v.e.c(f2Var.n())];
                    if (i == 1) {
                        return b2.f7091x;
                    }
                    if (i == 2) {
                        return b2.f7092y;
                    }
                }
            }
        }
        return b2.f7089v;
    }
}
