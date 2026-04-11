package app.cricfy.tv.activities;

import android.R;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;
import androidx.appcompat.widget.SearchView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.emoji2.text.v;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.i0;
import androidx.fragment.app.m0;
import androidx.fragment.app.r0;
import androidx.media3.decoder.DecoderInputBuffer;
import app.cricfy.tv.activities.MainActivity;
import app.cricfy.tv.app.ProApplication;
import c2.o;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;
import e.g;
import h.a;
import h.j;
import hd.e;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;
import me.ibrahimsn.lib.SmoothBottomBar;
import nb.w;
import org.json.JSONException;
import org.json.JSONObject;
import q5.m;
import q5.n;
import r5.d;
import r5.f;
import x5.b;
import x5.c;
import x5.i;
import x5.k;
import x5.l;
import x5.p;
import x5.r;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class MainActivity extends j {
    public static final /* synthetic */ int B0 = 0;
    public ProApplication W;
    public o X;
    public w Y;
    public e Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public a f1491a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public MenuItem f1492b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public c f1493c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public k f1494d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public x5.e f1495e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public i f1496f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public i f1497g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public p f1498h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public l f1499i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public b f1500j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public r f1501k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public y5.a f1502l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public String f1503m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public String f1504n0;
    public String o0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public boolean f1508s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public boolean f1509t0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public int f1511v0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public androidx.fragment.app.e f1513x0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public boolean f1505p0 = false;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public boolean f1506q0 = false;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public boolean f1507r0 = true;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public boolean f1510u0 = false;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public int f1512w0 = -1;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public final g f1514y0 = l(new nc.l(10), new m0(2));

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public final g f1515z0 = l(new r5.c(this), new m0(3));
    public final i0 A0 = new i0(this, 2);

    public static void w(MainActivity mainActivity, String str) {
        l lVar;
        if (str == null) {
            mainActivity.f1512w0 = 0;
            return;
        }
        mainActivity.f1512w0 = str.isEmpty() ? 0 : 2;
        r rVar = mainActivity.f1501k0;
        if (rVar != null) {
            rVar.T(str);
        } else if (!mainActivity.f1508s0 || (lVar = mainActivity.f1499i0) == null) {
            mainActivity.f1493c0.U(str);
        } else {
            lVar.U(str);
        }
    }

    public final void A() {
        if (this.f1498h0 != null) {
            r0 r0VarO = o();
            androidx.fragment.app.a aVarF = l0.e.f(r0VarO, r0VarO);
            aVarF.h(this.f1498h0);
            aVarF.e(false);
            this.f1498h0 = null;
        }
        ((FragmentContainerView) this.Z.f5929e).setVisibility(8);
    }

    public final void B() {
        ((FragmentContainerView) this.Z.f).setVisibility(8);
        r0 r0VarO = o();
        r0VarO.getClass();
        androidx.fragment.app.a aVar = new androidx.fragment.app.a(r0VarO);
        aVar.h(this.f1501k0);
        aVar.e(false);
        this.f1501k0 = null;
    }

    public final void C() {
        if (this.f1495e0 == null) {
            ((f6.a) new v(this).s(f6.a.class, "categories")).f3975d = new r5.c(this);
            x5.e eVar = new x5.e();
            Bundle bundle = new Bundle();
            bundle.putString("tag", "categories");
            eVar.N(bundle);
            this.f1495e0 = eVar;
            r0 r0VarO = o();
            androidx.fragment.app.a aVarF = l0.e.f(r0VarO, r0VarO);
            aVarF.f(q5.k.categories_fragment_container, this.f1495e0, null, 1);
            aVarF.e(false);
        }
        this.f1508s0 = false;
        this.f1507r0 = false;
        ((FragmentContainerView) this.Z.f5927c).setVisibility(8);
        ((FragmentContainerView) this.Z.f5931h).setVisibility(8);
        ((FragmentContainerView) this.Z.f5930g).setVisibility(8);
        ((FragmentContainerView) this.Z.f5928d).setVisibility(8);
        if (!this.f1505p0 || this.f1506q0) {
            this.f1506q0 = false;
            this.f1505p0 = false;
            this.f1493c0 = this.f1495e0;
            ((FragmentContainerView) this.Z.f5925a).setVisibility(0);
            ((FragmentContainerView) this.Z.f5926b).setVisibility(8);
            y();
        } else {
            E();
            this.f1506q0 = true;
            i iVar = this.f1496f0;
            this.f1493c0 = iVar;
            this.W.C = iVar.f14350w0;
            ((MaterialToolbar) this.Y.f9017x).setTitle(this.f1504n0);
            ((FragmentContainerView) this.Z.f5925a).setVisibility(8);
            ((FragmentContainerView) this.Z.f5926b).setVisibility(0);
        }
        if (this.f1512w0 == 0) {
            this.f1495e0.U("");
        }
    }

    public final void D() {
        if (this.f1494d0 == null) {
            f6.b bVar = (f6.b) new v(this).r(f6.b.class);
            y5.a aVar = this.f1502l0;
            bVar.f3977e = aVar.B;
            bVar.f = aVar.C;
            bVar.f3978g = aVar.F;
            bVar.f3979h = aVar.G;
            this.f1494d0 = new k();
            r0 r0VarO = o();
            androidx.fragment.app.a aVarF = l0.e.f(r0VarO, r0VarO);
            aVarF.f(q5.k.events_fragment_container, this.f1494d0, null, 1);
            aVarF.e(false);
        }
        this.f1507r0 = true;
        this.f1508s0 = false;
        this.f1506q0 = false;
        this.f1493c0 = this.f1494d0;
        ((FragmentContainerView) this.Z.f5927c).setVisibility(0);
        ((FragmentContainerView) this.Z.f5931h).setVisibility(8);
        ((FragmentContainerView) this.Z.f5930g).setVisibility(8);
        ((FragmentContainerView) this.Z.f5925a).setVisibility(8);
        ((FragmentContainerView) this.Z.f5926b).setVisibility(8);
        ((FragmentContainerView) this.Z.f5928d).setVisibility(8);
        y();
    }

    public final void E() {
        vf.g gVarN = n();
        Objects.requireNonNull(gVarN);
        gVarN.T(true);
        ((MaterialToolbar) this.Y.f9017x).setNavigationOnClickListener(new r5.e(this, 1));
    }

    @Override // h.j, c.m, h0.e, android.app.Activity
    public final void onCreate(Bundle bundle) {
        View viewL;
        h.p.k();
        super.onCreate(bundle);
        View viewInflate = getLayoutInflater().inflate(q5.l.activity_main, (ViewGroup) null, false);
        int i = q5.k.blur_bottom;
        FrameLayout frameLayout = (FrameLayout) android.support.v4.media.session.b.l(viewInflate, i);
        if (frameLayout != null) {
            i = q5.k.bottom_navigation;
            SmoothBottomBar smoothBottomBar = (SmoothBottomBar) android.support.v4.media.session.b.l(viewInflate, i);
            if (smoothBottomBar != null) {
                DrawerLayout drawerLayout = (DrawerLayout) viewInflate;
                i = q5.k.navigationView;
                NavigationView navigationView = (NavigationView) android.support.v4.media.session.b.l(viewInflate, i);
                if (navigationView != null) {
                    i = q5.k.overlay_layout;
                    if (((FrameLayout) android.support.v4.media.session.b.l(viewInflate, i)) != null && (viewL = android.support.v4.media.session.b.l(viewInflate, (i = q5.k.toolbarBinding))) != null) {
                        int i10 = q5.k.content;
                        View viewL2 = android.support.v4.media.session.b.l(viewL, i10);
                        if (viewL2 != null) {
                            e eVarA = e.a(viewL2);
                            int i11 = q5.k.toolbar;
                            MaterialToolbar materialToolbar = (MaterialToolbar) android.support.v4.media.session.b.l(viewL, i11);
                            if (materialToolbar != null) {
                                this.X = new o(drawerLayout, frameLayout, smoothBottomBar, drawerLayout, navigationView, new w(24, eVarA, materialToolbar), 7);
                                int i12 = Build.VERSION.SDK_INT;
                                if (i12 >= 35) {
                                    navigationView.setOnApplyWindowInsetsListener(new d(0));
                                }
                                setContentView((DrawerLayout) this.X.f2035b);
                                w wVar = (w) this.X.f2039g;
                                this.Y = wVar;
                                this.Z = (e) wVar.f9016w;
                                j().a(this.A0, this);
                                ProApplication proApplication = ProApplication.K;
                                this.W = proApplication;
                                proApplication.f1568v = this;
                                if (i12 >= 33 && i0.c.a(this, "android.permission.POST_NOTIFICATIONS") != 0 && !shouldShowRequestPermissionRationale("android.permission.POST_NOTIFICATIONS")) {
                                    this.f1514y0.a("android.permission.POST_NOTIFICATIONS");
                                }
                                this.f1503m0 = getString(q5.o.app_name);
                                Intent intent = getIntent();
                                if (i12 > 33) {
                                    this.f1502l0 = (y5.a) intent.getParcelableExtra("appDetail", y5.a.class);
                                } else {
                                    this.f1502l0 = (y5.a) intent.getParcelableExtra("appDetail");
                                }
                                v((MaterialToolbar) this.Y.f9017x);
                                a aVar = new a(this, (DrawerLayout) this.X.f2038e, (MaterialToolbar) this.Y.f9017x, q5.o.open_drawer, q5.o.close_drawer);
                                this.f1491a0 = aVar;
                                ((DrawerLayout) this.X.f2038e).a(aVar);
                                this.f1491a0.e();
                                ((MaterialToolbar) this.Y.f9017x).setTitleTextColor(-1);
                                j.g gVar = this.f1491a0.f5259c;
                                Paint paint = gVar.f6491a;
                                if (-1 != paint.getColor()) {
                                    paint.setColor(-1);
                                    gVar.invalidateSelf();
                                }
                                this.o0 = this.f1503m0;
                                ((FrameLayout) this.X.f2036c).post(new f(this, 1));
                                ((SmoothBottomBar) this.X.f2037d).setOnItemSelectedListener(new r5.c(this));
                                ((NavigationView) this.X.f).setNavigationItemSelectedListener(new r5.c(this));
                                try {
                                    PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
                                    if (i12 >= 29) {
                                        this.f1511v0 = (int) packageInfo.getLongVersionCode();
                                    } else {
                                        this.f1511v0 = packageInfo.versionCode;
                                    }
                                } catch (PackageManager.NameNotFoundException e9) {
                                    e9.printStackTrace();
                                }
                                int i13 = getApplicationInfo().targetSdkVersion;
                                int i14 = Build.VERSION.SDK_INT >= 24 ? getApplicationInfo().minSdkVersion : 21;
                                int i15 = this.f1511v0;
                                if (!com.bumptech.glide.d.t(this).getBoolean("is_tv", false)) {
                                    if (i15 > 43 || i15 < 43) {
                                        throw new RuntimeException("");
                                    }
                                    if (i13 != 36 || i14 != 23) {
                                        throw new RuntimeException("");
                                    }
                                    String absolutePath = getFilesDir().getAbsolutePath();
                                    int i16 = 0;
                                    for (int i17 = 0; i17 < absolutePath.length() && i16 <= 2; i17++) {
                                        if (absolutePath.charAt(i17) == '.') {
                                            i16++;
                                        }
                                    }
                                    if (i16 > 2) {
                                        throw new RuntimeException("");
                                    }
                                    InputStream inputStreamOpenRawResource = getResources().openRawResource(new int[]{n.live}[0]);
                                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpenRawResource));
                                    StringBuilder sb = new StringBuilder();
                                    while (true) {
                                        try {
                                            try {
                                                try {
                                                    String line = bufferedReader.readLine();
                                                    if (line == null) {
                                                        break;
                                                    } else {
                                                        sb.append(line);
                                                    }
                                                } catch (IOException e10) {
                                                    e10.printStackTrace();
                                                    inputStreamOpenRawResource.close();
                                                }
                                            } finally {
                                            }
                                        } catch (IOException e11) {
                                            e11.printStackTrace();
                                        }
                                    }
                                    inputStreamOpenRawResource.close();
                                    bufferedReader.close();
                                    try {
                                        new JSONObject(sb.toString());
                                        try {
                                            String[] strArr = getPackageManager().getPackageInfo(getPackageName(), 4096).requestedPermissions;
                                            if (strArr != null) {
                                                String strB = a6.a.b("LW5ejc9qSJ5wSYZxfYDsfW9hNnPIVIZSY0PCXP9TTHDNTHkPHw==");
                                                for (String str : strArr) {
                                                    if (str.equals(strB)) {
                                                        a6.b.a(this);
                                                    }
                                                }
                                            }
                                        } catch (PackageManager.NameNotFoundException unused) {
                                        }
                                        throw new RuntimeException("");
                                    } catch (JSONException unused2) {
                                        throw new RuntimeException("");
                                    }
                                }
                                if (!a6.b.f301a || !a6.b.f302b) {
                                    throw new RuntimeException("");
                                }
                                this.f1510u0 = true;
                                D();
                                if (!this.f1510u0) {
                                    throw new RuntimeException("");
                                }
                                o().a0(this, new r5.c(this));
                                String str2 = this.f1502l0.H;
                                if (str2 == null || !str2.trim().startsWith("http")) {
                                    v5.o.a(this, this.f1502l0.f14906x);
                                } else {
                                    String str3 = this.f1502l0.I;
                                    b bVar = new b();
                                    Bundle bundle2 = new Bundle();
                                    bundle2.putString("arg_ad", str2);
                                    bundle2.putString("arg_action", str3);
                                    bVar.N(bundle2);
                                    this.f1500j0 = bVar;
                                    r0 r0VarO = o();
                                    androidx.fragment.app.a aVarF = l0.e.f(r0VarO, r0VarO);
                                    aVarF.f912b = R.anim.fade_in;
                                    aVarF.f913c = R.anim.fade_out;
                                    aVarF.f914d = 0;
                                    aVarF.f915e = 0;
                                    aVarF.f(R.id.content, this.f1500j0, null, 1);
                                    aVarF.c(null);
                                    aVarF.e(false);
                                }
                                this.W.f1571y = new r5.c(this);
                                File externalFilesDir = getExternalFilesDir(null);
                                if (externalFilesDir == null) {
                                    return;
                                }
                                l4.a.E(externalFilesDir);
                                return;
                            }
                            i10 = i11;
                        }
                        throw new NullPointerException("Missing required view with ID: ".concat(viewL.getResources().getResourceName(i10)));
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    @Override // android.app.Activity
    public final boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(m.menu_buttons, menu);
        final int i = 0;
        menu.findItem(q5.k.refresh).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this) { // from class: r5.i

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ MainActivity f10869b;

            {
                this.f10869b = this;
            }

            @Override // android.view.MenuItem.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                int i10 = i;
                MainActivity mainActivity = this.f10869b;
                switch (i10) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        x5.c cVar = mainActivity.f1493c0;
                        if (cVar != null) {
                            cVar.T();
                        }
                        break;
                    case 1:
                        int i11 = MainActivity.B0;
                        mainActivity.A();
                        if (mainActivity.f1501k0 != null) {
                            mainActivity.B();
                        }
                        mainActivity.f1499i0 = new x5.l();
                        r0 r0VarO = mainActivity.o();
                        androidx.fragment.app.a aVarF = l0.e.f(r0VarO, r0VarO);
                        aVarF.f(q5.k.fav_fragment_container, mainActivity.f1499i0, null, 1);
                        aVarF.e(false);
                        mainActivity.f1508s0 = true;
                        ((FragmentContainerView) mainActivity.Z.f5928d).setVisibility(0);
                        ((MaterialToolbar) mainActivity.Y.f9017x).setTitle("Favourites");
                        mainActivity.E();
                        break;
                    default:
                        int i12 = MainActivity.B0;
                        mainActivity.z();
                        if (mainActivity.f1501k0 != null) {
                            mainActivity.B();
                        }
                        mainActivity.f1498h0 = new x5.p();
                        r0 r0VarO2 = mainActivity.o();
                        androidx.fragment.app.a aVarF2 = l0.e.f(r0VarO2, r0VarO2);
                        aVarF2.f(q5.k.noti_fragment_container, mainActivity.f1498h0, null, 1);
                        aVarF2.e(false);
                        ((FragmentContainerView) mainActivity.Z.f5929e).setVisibility(0);
                        ((MaterialToolbar) mainActivity.Y.f9017x).setTitle("Notifications");
                        mainActivity.E();
                        break;
                }
                return true;
            }
        });
        final int i10 = 1;
        menu.findItem(q5.k.fav).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this) { // from class: r5.i

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ MainActivity f10869b;

            {
                this.f10869b = this;
            }

            @Override // android.view.MenuItem.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                int i102 = i10;
                MainActivity mainActivity = this.f10869b;
                switch (i102) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        x5.c cVar = mainActivity.f1493c0;
                        if (cVar != null) {
                            cVar.T();
                        }
                        break;
                    case 1:
                        int i11 = MainActivity.B0;
                        mainActivity.A();
                        if (mainActivity.f1501k0 != null) {
                            mainActivity.B();
                        }
                        mainActivity.f1499i0 = new x5.l();
                        r0 r0VarO = mainActivity.o();
                        androidx.fragment.app.a aVarF = l0.e.f(r0VarO, r0VarO);
                        aVarF.f(q5.k.fav_fragment_container, mainActivity.f1499i0, null, 1);
                        aVarF.e(false);
                        mainActivity.f1508s0 = true;
                        ((FragmentContainerView) mainActivity.Z.f5928d).setVisibility(0);
                        ((MaterialToolbar) mainActivity.Y.f9017x).setTitle("Favourites");
                        mainActivity.E();
                        break;
                    default:
                        int i12 = MainActivity.B0;
                        mainActivity.z();
                        if (mainActivity.f1501k0 != null) {
                            mainActivity.B();
                        }
                        mainActivity.f1498h0 = new x5.p();
                        r0 r0VarO2 = mainActivity.o();
                        androidx.fragment.app.a aVarF2 = l0.e.f(r0VarO2, r0VarO2);
                        aVarF2.f(q5.k.noti_fragment_container, mainActivity.f1498h0, null, 1);
                        aVarF2.e(false);
                        ((FragmentContainerView) mainActivity.Z.f5929e).setVisibility(0);
                        ((MaterialToolbar) mainActivity.Y.f9017x).setTitle("Notifications");
                        mainActivity.E();
                        break;
                }
                return true;
            }
        });
        final int i11 = 2;
        menu.findItem(q5.k.noti).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this) { // from class: r5.i

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ MainActivity f10869b;

            {
                this.f10869b = this;
            }

            @Override // android.view.MenuItem.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                int i102 = i11;
                MainActivity mainActivity = this.f10869b;
                switch (i102) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        x5.c cVar = mainActivity.f1493c0;
                        if (cVar != null) {
                            cVar.T();
                        }
                        break;
                    case 1:
                        int i112 = MainActivity.B0;
                        mainActivity.A();
                        if (mainActivity.f1501k0 != null) {
                            mainActivity.B();
                        }
                        mainActivity.f1499i0 = new x5.l();
                        r0 r0VarO = mainActivity.o();
                        androidx.fragment.app.a aVarF = l0.e.f(r0VarO, r0VarO);
                        aVarF.f(q5.k.fav_fragment_container, mainActivity.f1499i0, null, 1);
                        aVarF.e(false);
                        mainActivity.f1508s0 = true;
                        ((FragmentContainerView) mainActivity.Z.f5928d).setVisibility(0);
                        ((MaterialToolbar) mainActivity.Y.f9017x).setTitle("Favourites");
                        mainActivity.E();
                        break;
                    default:
                        int i12 = MainActivity.B0;
                        mainActivity.z();
                        if (mainActivity.f1501k0 != null) {
                            mainActivity.B();
                        }
                        mainActivity.f1498h0 = new x5.p();
                        r0 r0VarO2 = mainActivity.o();
                        androidx.fragment.app.a aVarF2 = l0.e.f(r0VarO2, r0VarO2);
                        aVarF2.f(q5.k.noti_fragment_container, mainActivity.f1498h0, null, 1);
                        aVarF2.e(false);
                        ((FragmentContainerView) mainActivity.Z.f5929e).setVisibility(0);
                        ((MaterialToolbar) mainActivity.Y.f9017x).setTitle("Notifications");
                        mainActivity.E();
                        break;
                }
                return true;
            }
        });
        MenuItem menuItemFindItem = menu.findItem(q5.k.search);
        this.f1492b0 = menuItemFindItem;
        menuItemFindItem.setOnActionExpandListener(new r5.j(this));
        SearchView searchView = (SearchView) this.f1492b0.getActionView();
        SearchView.SearchAutoComplete searchAutoComplete = (SearchView.SearchAutoComplete) searchView.findViewById(g.f.search_src_text);
        searchAutoComplete.setHintTextColor(getColor(q5.i.gray_77));
        searchAutoComplete.setTextColor(-1);
        searchView.setQueryHint("Search..");
        searchView.setOnQueryTextListener(new m2.e(this));
        return super.onCreateOptionsMenu(menu);
    }

    public final void x() {
        if (this.f1512w0 != -1) {
            this.f1512w0 = 0;
        }
        b bVar = this.f1500j0;
        if (bVar != null) {
            if (bVar.f14335x0 <= 0) {
                r0 r0VarO = o();
                androidx.fragment.app.a aVarF = l0.e.f(r0VarO, r0VarO);
                aVarF.h(this.f1500j0);
                aVarF.e(false);
                this.f1500j0 = null;
                v5.o.a(this, this.f1502l0.f14906x);
                return;
            }
            return;
        }
        r rVar = this.f1501k0;
        if (rVar != null) {
            if (rVar.R()) {
                return;
            }
            B();
            if (!this.f1506q0) {
                y();
            }
            ((MaterialToolbar) this.Y.f9017x).setTitle(this.o0);
            return;
        }
        if (this.f1498h0 != null) {
            A();
            if (!this.f1506q0) {
                y();
            }
            ((MaterialToolbar) this.Y.f9017x).setTitle(this.o0);
            return;
        }
        if (this.f1499i0 != null) {
            z();
            if (!this.f1506q0) {
                y();
            }
            ((MaterialToolbar) this.Y.f9017x).setTitle(this.o0);
            return;
        }
        if (this.f1506q0) {
            this.f1496f0.getClass();
            y();
            this.f1506q0 = false;
            this.f1505p0 = false;
            this.f1496f0 = null;
            ((SmoothBottomBar) this.X.f2037d).setItemActiveIndex(2);
            C();
            return;
        }
        if (!this.f1507r0) {
            ((SmoothBottomBar) this.X.f2037d).setItemActiveIndex(0);
            D();
        } else {
            if (this.f1509t0) {
                finish();
                return;
            }
            Toast.makeText(this, "Tap again to exit", 0).show();
            this.f1509t0 = true;
            new Handler(Looper.getMainLooper()).postDelayed(new f(this, 0), 2000L);
        }
    }

    public final void y() {
        vf.g gVarN = n();
        Objects.requireNonNull(gVarN);
        gVarN.T(false);
        this.f1491a0.getClass();
        this.f1491a0.e();
        ((MaterialToolbar) this.Y.f9017x).setNavigationOnClickListener(new r5.e(this, 0));
    }

    public final void z() {
        if (this.f1499i0 != null) {
            r0 r0VarO = o();
            androidx.fragment.app.a aVarF = l0.e.f(r0VarO, r0VarO);
            aVarF.h(this.f1499i0);
            aVarF.e(false);
            this.f1499i0 = null;
            this.f1508s0 = false;
        }
        ((FragmentContainerView) this.Z.f5928d).setVisibility(8);
    }
}
