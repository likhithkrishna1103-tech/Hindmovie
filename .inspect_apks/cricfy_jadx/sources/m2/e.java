package m2;

import android.content.ClipData;
import android.content.ContentProviderClient;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.ContentInfo;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.profileinstaller.ProfileInstallReceiver;
import com.google.android.material.appbar.AppBarLayout;
import f9.z1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import kf.c0;
import m4.j0;
import m4.s0;
import o.h2;
import o.x0;
import o.y2;
import org.json.JSONObject;
import t0.p1;
import vc.m0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class e implements s0, t0.o, h2, j9.h, x0, n.i, o8.b, q0.a, y2, t0.c, t4.b, u2.d, xc.b, j9.d, t7.a {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Object f8050v;

    public /* synthetic */ e(Object obj) {
        this.f8050v = obj;
    }

    public static void m(l7.a aVar, vb.d dVar) {
        String str = dVar.f13553a;
        if (str != null) {
            aVar.z("X-CRASHLYTICS-GOOGLE-APP-ID", str);
        }
        aVar.z("X-CRASHLYTICS-API-CLIENT-TYPE", "android");
        aVar.z("X-CRASHLYTICS-API-CLIENT-VERSION", "20.0.4");
        aVar.z("Accept", "application/json");
        String str2 = dVar.f13554b;
        if (str2 != null) {
            aVar.z("X-CRASHLYTICS-DEVICE-MODEL", str2);
        }
        String str3 = dVar.f13555c;
        if (str3 != null) {
            aVar.z("X-CRASHLYTICS-OS-BUILD-VERSION", str3);
        }
        String str4 = dVar.f13556d;
        if (str4 != null) {
            aVar.z("X-CRASHLYTICS-OS-DISPLAY-VERSION", str4);
        }
        String str5 = dVar.f13557e.c().f8925a;
        if (str5 != null) {
            aVar.z("X-CRASHLYTICS-INSTALLATION-ID", str5);
        }
    }

    public static HashMap s(vb.d dVar) {
        HashMap map = new HashMap();
        map.put("build_version", dVar.f13559h);
        map.put("display_version", dVar.f13558g);
        map.put("source", Integer.toString(dVar.i));
        String str = dVar.f;
        if (!TextUtils.isEmpty(str)) {
            map.put("instance", str);
        }
        return map;
    }

    @Override // j9.d
    public void A(j9.p pVar) {
        Exception excG = pVar.g();
        if (excG != null) {
            ((pe.h) this.f8050v).i(com.bumptech.glide.c.e(excG));
        } else if (pVar.f6709d) {
            ((pe.h) this.f8050v).q(null);
        } else {
            ((pe.h) this.f8050v).i(pVar.h());
        }
    }

    @Override // j9.h
    public j9.p B(Object obj) {
        vb.a aVar = (vb.a) obj;
        nb.l lVar = ((nb.j) this.f8050v).f8950e;
        if (aVar != null) {
            return vf.g.b0(Arrays.asList(nb.l.a(lVar), lVar.f8965m.w(null, lVar.f8959e.f9742a)));
        }
        Log.w("FirebaseCrashlytics", "Received null app settings, cannot send reports at crash time.", null);
        return vf.g.A(null);
    }

    @Override // q0.a
    public Cursor b(Uri uri, String[] strArr, String[] strArr2) {
        ContentProviderClient contentProviderClient = (ContentProviderClient) this.f8050v;
        if (contentProviderClient == null) {
            return null;
        }
        try {
            return contentProviderClient.query(uri, strArr, "query = ?", strArr2, null, null);
        } catch (RemoteException e9) {
            Log.w("FontsProvider", "Unable to query the content provider", e9);
            return null;
        }
    }

    @Override // t0.c
    public t0.f build() {
        return new t0.f(new kf.i(((ContentInfo.Builder) this.f8050v).build()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // q0.a
    public void close() throws Exception {
        ContentProviderClient contentProviderClient = (ContentProviderClient) this.f8050v;
        if (contentProviderClient != 0) {
            if (contentProviderClient instanceof AutoCloseable) {
                contentProviderClient.close();
            } else if (contentProviderClient instanceof ExecutorService) {
                a9.b.y((ExecutorService) contentProviderClient);
            } else {
                contentProviderClient.release();
            }
        }
    }

    @Override // o8.b
    public void e(int i) {
        ((m8.c) this.f8050v).e(i);
    }

    @Override // o8.b
    public void f() {
        ((m8.c) this.f8050v).f();
    }

    @Override // o.h2
    public void g(n.k kVar, MenuItem menuItem) {
        ((n.e) this.f8050v).A.removeCallbacksAndMessages(kVar);
    }

    @Override // qd.a
    public Object get() {
        ab.g gVar = (ab.g) ((ma.e) this.f8050v).f8417v;
        ge.i.e(gVar, "firebaseApp");
        m0 m0Var = m0.f13665a;
        return m0.a(gVar);
    }

    @Override // t4.b
    public void h() {
        Log.d("ProfileInstaller", "DIAGNOSTIC_PROFILE_IS_COMPRESSED");
    }

    @Override // t0.c
    public void i(Uri uri) {
        ((ContentInfo.Builder) this.f8050v).setLinkUri(uri);
    }

    @Override // t4.b
    public void j(int i, Object obj) {
        String str;
        switch (i) {
            case 1:
                str = "RESULT_INSTALL_SUCCESS";
                break;
            case 2:
                str = "RESULT_ALREADY_INSTALLED";
                break;
            case 3:
                str = "RESULT_UNSUPPORTED_ART_VERSION";
                break;
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                str = "RESULT_NOT_WRITABLE";
                break;
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
                str = "RESULT_DESIRED_FORMAT_UNSUPPORTED";
                break;
            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                str = "RESULT_BASELINE_PROFILE_NOT_FOUND";
                break;
            case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                str = "RESULT_IO_EXCEPTION";
                break;
            case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                str = "RESULT_PARSE_EXCEPTION";
                break;
            case 9:
            default:
                str = "";
                break;
            case 10:
                str = "RESULT_INSTALL_SKIP_FILE_SUCCESS";
                break;
            case 11:
                str = "RESULT_DELETE_SKIP_FILE_SUCCESS";
                break;
        }
        if (i == 6 || i == 7 || i == 8) {
            Log.e("ProfileInstaller", str, (Throwable) obj);
        } else {
            Log.d("ProfileInstaller", str);
        }
        ((ProfileInstallReceiver) this.f8050v).setResultCode(i);
    }

    @Override // t0.o
    public p1 k(View view, p1 p1Var) {
        AppBarLayout appBarLayout = (AppBarLayout) this.f8050v;
        p1 p1Var2 = appBarLayout.getFitsSystemWindows() ? p1Var : null;
        if (!Objects.equals(appBarLayout.B, p1Var2)) {
            appBarLayout.B = p1Var2;
            appBarLayout.setWillNotDraw(!(appBarLayout.R != null && appBarLayout.getTopInset() > 0));
            appBarLayout.requestLayout();
        }
        return p1Var;
    }

    @Override // t0.c
    public void l(int i) {
        ((ContentInfo.Builder) this.f8050v).setFlags(i);
    }

    @Override // o.h2
    public void n(n.k kVar, n.m mVar) {
        n.e eVar = (n.e) this.f8050v;
        Handler handler = eVar.A;
        handler.removeCallbacksAndMessages(null);
        ArrayList arrayList = eVar.C;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            } else if (kVar == ((n.d) arrayList.get(i)).f8500b) {
                break;
            } else {
                i++;
            }
        }
        if (i == -1) {
            return;
        }
        int i10 = i + 1;
        handler.postAtTime(new z1(this, i10 < arrayList.size() ? (n.d) arrayList.get(i10) : null, mVar, kVar, 9, false), kVar, SystemClock.uptimeMillis() + 200);
    }

    @Override // t7.a
    public Object o() {
        f3.a aVar = (f3.a) this.f8050v;
        return new z6.k((l8.i) aVar.f3936x, (l7.a) aVar.f3937y);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String p(v1.p r8) {
        /*
            r7 = this;
            java.lang.String r0 = r8.f12938d
            java.lang.String r1 = r8.f12936b
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r3 = ""
            if (r2 != 0) goto L42
            java.lang.String r2 = "und"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L15
            goto L42
        L15:
            int r2 = y1.a0.f14551a
            r4 = 21
            if (r2 < r4) goto L20
            java.util.Locale r0 = java.util.Locale.forLanguageTag(r0)
            goto L26
        L20:
            java.util.Locale r2 = new java.util.Locale
            r2.<init>(r0)
            r0 = r2
        L26:
            int r2 = android.os.Build.VERSION.SDK_INT
            r4 = 24
            if (r2 < r4) goto L34
            i2.a0.C()
            java.util.Locale r2 = i2.a0.D()
            goto L38
        L34:
            java.util.Locale r2 = java.util.Locale.getDefault()
        L38:
            java.lang.String r0 = r0.getDisplayName(r2)
            boolean r4 = android.text.TextUtils.isEmpty(r0)
            if (r4 == 0) goto L44
        L42:
            r0 = r3
            goto L65
        L44:
            r4 = 1
            r5 = 0
            int r4 = r0.offsetByCodePoints(r5, r4)     // Catch: java.lang.IndexOutOfBoundsException -> L65
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.IndexOutOfBoundsException -> L65
            r6.<init>()     // Catch: java.lang.IndexOutOfBoundsException -> L65
            java.lang.String r5 = r0.substring(r5, r4)     // Catch: java.lang.IndexOutOfBoundsException -> L65
            java.lang.String r2 = r5.toUpperCase(r2)     // Catch: java.lang.IndexOutOfBoundsException -> L65
            r6.append(r2)     // Catch: java.lang.IndexOutOfBoundsException -> L65
            java.lang.String r2 = r0.substring(r4)     // Catch: java.lang.IndexOutOfBoundsException -> L65
            r6.append(r2)     // Catch: java.lang.IndexOutOfBoundsException -> L65
            java.lang.String r0 = r6.toString()     // Catch: java.lang.IndexOutOfBoundsException -> L65
        L65:
            java.lang.String r8 = r7.q(r8)
            java.lang.String[] r8 = new java.lang.String[]{r0, r8}
            java.lang.String r8 = r7.v(r8)
            boolean r0 = android.text.TextUtils.isEmpty(r8)
            if (r0 == 0) goto L7f
            boolean r8 = android.text.TextUtils.isEmpty(r1)
            if (r8 == 0) goto L7e
            r1 = r3
        L7e:
            r8 = r1
        L7f:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: m2.e.p(v1.p):java.lang.String");
    }

    public String q(v1.p pVar) {
        Resources resources = (Resources) this.f8050v;
        int i = pVar.f;
        int i10 = pVar.f;
        String string = (i & 2) != 0 ? resources.getString(j0.exo_track_role_alternate) : "";
        if ((i10 & 4) != 0) {
            string = v(string, resources.getString(j0.exo_track_role_supplementary));
        }
        if ((i10 & 8) != 0) {
            string = v(string, resources.getString(j0.exo_track_role_commentary));
        }
        return (i10 & 1088) != 0 ? v(string, resources.getString(j0.exo_track_role_closed_captions)) : string;
    }

    public synchronized void r(c0 c0Var) {
        ge.i.e(c0Var, "route");
        ((LinkedHashSet) this.f8050v).remove(c0Var);
    }

    @Override // t0.c
    public void setExtras(Bundle bundle) {
        ((ContentInfo.Builder) this.f8050v).setExtras(bundle);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String t(v1.p r13) {
        /*
            Method dump skipped, instruction units count: 228
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m2.e.t(v1.p):java.lang.String");
    }

    public JSONObject u(ag.o oVar) {
        String str = (String) this.f8050v;
        int i = oVar.f454w;
        kb.c cVar = kb.c.f7396a;
        cVar.e("Settings response code was: " + i);
        if (i != 200 && i != 201 && i != 202 && i != 203) {
            String str2 = "Settings request failed; (status: " + i + ") from " + str;
            if (cVar.a(6)) {
                Log.e("FirebaseCrashlytics", str2, null);
            }
            return null;
        }
        String str3 = (String) oVar.f455x;
        try {
            return new JSONObject(str3);
        } catch (Exception e9) {
            cVar.f("Failed to parse settings JSON from " + str, e9);
            cVar.f("Settings response " + str3, null);
            return null;
        }
    }

    public String v(String... strArr) {
        String string = "";
        for (String str : strArr) {
            if (str.length() > 0) {
                string = TextUtils.isEmpty(string) ? str : ((Resources) this.f8050v).getString(j0.exo_item_list, string, str);
            }
        }
        return string;
    }

    @Override // n.i
    public boolean x(n.k kVar, MenuItem menuItem) {
        return false;
    }

    @Override // n.i
    public void y(n.k kVar) {
        Toolbar toolbar = (Toolbar) this.f8050v;
        o.k kVar2 = toolbar.f619v.O;
        if (kVar2 == null || !kVar2.f()) {
            Iterator it = ((CopyOnWriteArrayList) toolbar.f606e0.f7867x).iterator();
            while (it.hasNext()) {
                ((androidx.fragment.app.j0) it.next()).f1007a.t();
            }
        }
        p6.d dVar = toolbar.f614m0;
        if (dVar != null) {
            dVar.y(kVar);
        }
    }

    public e(int i) {
        switch (i) {
            case 11:
                this.f8050v = new LinkedHashSet();
                break;
            case 18:
                this.f8050v = new x3.e();
                break;
            default:
                this.f8050v = new d(5, 1.0f, false);
                break;
        }
    }

    public e(Resources resources) {
        resources.getClass();
        this.f8050v = resources;
    }

    public e(ClipData clipData, int i) {
        this.f8050v = i2.a.k(clipData, i);
    }

    @Override // o.x0
    public void a(int i) {
    }

    @Override // o.x0
    public void c(int i) {
    }

    @Override // o.x0
    public void d(int i, float f) {
    }
}
