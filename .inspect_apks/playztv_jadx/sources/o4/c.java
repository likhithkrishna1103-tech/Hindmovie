package o4;

import android.R;
import android.content.ClipData;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.ContentInfo;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import androidx.profileinstaller.ProfileInstallReceiver;
import androidx.recyclerview.widget.RecyclerView;
import c2.v;
import com.google.android.material.appbar.AppBarLayout;
import ea.e0;
import j9.g0;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import o8.o;
import q0.o0;
import q0.p;
import q0.r1;
import q4.f1;
import q4.h0;
import q4.i0;
import ta.k;
import ta.m;
import ue.a0;
import ue.x;
import wa.t1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class c implements d, o8.e, o8.d, o8.b, q0.c, q0.i, f1, p, t7.b, o8.g, o8.c, y4.b, ue.e {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Object f9349u;

    public /* synthetic */ c(Object obj) {
        this.f9349u = obj;
    }

    @Override // o8.c
    public void A(o oVar) {
        Exception excG = oVar.g();
        if (excG != null) {
            ((ke.g) this.f9349u).g(i5.a.h(excG));
        } else if (oVar.f9442d) {
            ((ke.g) this.f9349u).q(null);
        } else {
            ((ke.g) this.f9349u).g(oVar.h());
        }
    }

    public boolean B(int i, int i10, Bundle bundle) {
        return false;
    }

    @Override // q0.p
    public r1 C(View view, r1 r1Var) {
        AppBarLayout appBarLayout = (AppBarLayout) this.f9349u;
        WeakHashMap weakHashMap = o0.f10475a;
        r1 r1Var2 = appBarLayout.getFitsSystemWindows() ? r1Var : null;
        if (!Objects.equals(appBarLayout.A, r1Var2)) {
            appBarLayout.A = r1Var2;
            appBarLayout.setWillNotDraw(!(appBarLayout.O != null && appBarLayout.getTopInset() > 0));
            appBarLayout.requestLayout();
        }
        return r1Var;
    }

    public void D() {
        View viewFindViewById;
        View view = (View) this.f9349u;
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
        viewFindViewById.post(new g0(viewFindViewById, 1));
    }

    @Override // y4.b
    public y4.a a(String str) {
        be.h.e(str, "fileName");
        return new u4.a(((z4.b) this.f9349u).Z());
    }

    @Override // q4.f1
    public int b() {
        h0 h0Var = (h0) this.f9349u;
        return h0Var.f10828n - h0Var.E();
    }

    @Override // q0.c
    public q0.g build() {
        return new q0.g(new q0.e(((ContentInfo.Builder) this.f9349u).build()));
    }

    @Override // o8.e
    public void c(Object obj) {
        ((CountDownLatch) this.f9349u).countDown();
    }

    @Override // ue.e
    public void d(IOException iOException) {
        ((e0) this.f9349u).l(iOException);
    }

    @Override // t7.b
    public void e(int i) {
        ((r7.c) this.f9349u).e(i);
    }

    @Override // t7.b
    public void f() {
        ((r7.c) this.f9349u).f();
    }

    @Override // q4.f1
    public int g(View view) {
        return (view.getLeft() - ((i0) view.getLayoutParams()).f10832b.left) - ((ViewGroup.MarginLayoutParams) ((i0) view.getLayoutParams())).leftMargin;
    }

    @Override // o8.b
    public void h() {
        ((CountDownLatch) this.f9349u).countDown();
    }

    @Override // q0.i
    public boolean i(float f) {
        int i;
        int i10;
        RecyclerView recyclerView = (RecyclerView) this.f9349u;
        if (recyclerView.H.e()) {
            i10 = (int) f;
            i = 0;
        } else if (recyclerView.H.d()) {
            i = (int) f;
            i10 = 0;
        } else {
            i = 0;
            i10 = 0;
        }
        if (i == 0 && i10 == 0) {
            return false;
        }
        recyclerView.o0();
        return recyclerView.I(i, i10, 0, Integer.MAX_VALUE);
    }

    @Override // ue.e
    public void j(x xVar) {
        ((e0) this.f9349u).k(xVar);
    }

    @Override // q4.f1
    public View k(int i) {
        return ((h0) this.f9349u).u(i);
    }

    @Override // o4.d
    public void l() {
        Log.d("ProfileInstaller", "DIAGNOSTIC_PROFILE_IS_COMPRESSED");
    }

    @Override // o4.d
    public void m(int i, Object obj) {
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
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                str = "RESULT_NOT_WRITABLE";
                break;
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                str = "RESULT_DESIRED_FORMAT_UNSUPPORTED";
                break;
            case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                str = "RESULT_BASELINE_PROFILE_NOT_FOUND";
                break;
            case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                str = "RESULT_IO_EXCEPTION";
                break;
            case 8:
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
        ((ProfileInstallReceiver) this.f9349u).setResultCode(i);
    }

    @Override // q4.f1
    public int n() {
        return ((h0) this.f9349u).D();
    }

    @Override // q0.c
    public void o(Uri uri) {
        ((ContentInfo.Builder) this.f9349u).setLinkUri(uri);
    }

    @Override // q4.f1
    public int p(View view) {
        return view.getRight() + ((i0) view.getLayoutParams()).f10832b.right + ((ViewGroup.MarginLayoutParams) ((i0) view.getLayoutParams())).rightMargin;
    }

    @Override // q0.i
    public float q() {
        float f;
        RecyclerView recyclerView = (RecyclerView) this.f9349u;
        if (recyclerView.H.e()) {
            f = recyclerView.f1665v0;
        } else {
            if (!recyclerView.H.d()) {
                return 0.0f;
            }
            f = recyclerView.f1663u0;
        }
        return -f;
    }

    @Override // o8.g
    public o r(Object obj) {
        bb.c cVar = (bb.c) obj;
        m mVar = ((k) this.f9349u).f12377e;
        if (cVar != null) {
            return t1.x(Arrays.asList(m.a(mVar), mVar.f12391m.u(null, mVar.f12385e.f12823a)));
        }
        Log.w("FirebaseCrashlytics", "Received null app settings, cannot send reports at crash time.", null);
        return t1.k(null);
    }

    @Override // q0.i
    public void s() {
        ((RecyclerView) this.f9349u).o0();
    }

    @Override // q0.c
    public void setExtras(Bundle bundle) {
        ((ContentInfo.Builder) this.f9349u).setExtras(bundle);
    }

    @Override // o8.d
    public void t(Exception exc) {
        ((CountDownLatch) this.f9349u).countDown();
    }

    @Override // q0.c
    public void u(int i) {
        ((ContentInfo.Builder) this.f9349u).setFlags(i);
    }

    public synchronized void v(a0 a0Var) {
        be.h.e(a0Var, "route");
        ((LinkedHashSet) this.f9349u).remove(a0Var);
    }

    public r0.e w(int i) {
        return null;
    }

    public synchronized void x() {
        ((SharedPreferences) this.f9349u).edit().clear().commit();
    }

    public r0.e y(int i) {
        return null;
    }

    public void z() {
        View view = (View) this.f9349u;
        if (view != null) {
            ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public c(int i) {
        switch (i) {
            case 8:
                if (Build.VERSION.SDK_INT < 26) {
                    this.f9349u = new r0.f(this);
                } else {
                    this.f9349u = new r0.g(this);
                }
                break;
            case 10:
                this.f9349u = new CopyOnWriteArrayList();
                break;
            case 17:
                this.f9349u = new LinkedHashSet();
                break;
            default:
                this.f9349u = new CountDownLatch(1);
                break;
        }
    }

    public c(z4.b bVar) {
        be.h.e(bVar, "openHelper");
        this.f9349u = bVar;
    }

    public c(Context context) {
        boolean zIsEmpty;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.android.gms.appid", 0);
        this.f9349u = sharedPreferences;
        File file = new File(context.getNoBackupFilesDir(), "com.google.android.gms.appid-no-backup");
        if (file.exists()) {
            return;
        }
        try {
            if (file.createNewFile()) {
                synchronized (this) {
                    zIsEmpty = sharedPreferences.getAll().isEmpty();
                }
                if (zIsEmpty) {
                    return;
                }
                Log.i("FirebaseMessaging", "App restored, clearing state");
                x();
            }
        } catch (IOException e10) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Error creating file in no backup dir: " + e10.getMessage());
            }
        }
    }

    public c(k kVar, String str) {
        this.f9349u = kVar;
    }

    public c(ClipData clipData, int i) {
        this.f9349u = v.j(clipData, i);
    }
}
