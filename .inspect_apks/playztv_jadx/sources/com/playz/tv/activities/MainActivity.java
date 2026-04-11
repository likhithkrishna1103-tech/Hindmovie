package com.playz.tv.activities;

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
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.f0;
import androidx.fragment.app.j0;
import androidx.fragment.app.n0;
import androidx.media3.decoder.DecoderInputBuffer;
import b2.b;
import b2.g;
import c7.h;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.playz.tv.activities.MainActivity;
import com.playz.tv.app.ProApplication;
import f0.c;
import g4.s0;
import gc.k;
import gc.l;
import gc.n;
import h.a;
import h.j;
import h.q;
import h4.z;
import hc.d;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;
import n.a1;
import nc.e;
import nc.f;
import nc.m;
import nc.o;
import nc.p;
import nc.s;
import nc.u;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class MainActivity extends j {
    public static final /* synthetic */ int F0 = 0;
    public b B0;
    public ProApplication V;
    public g W;
    public z X;
    public h Y;
    public a Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public MenuItem f3597a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public f f3598b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public o f3599c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public nc.h f3600d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public nc.h f3601e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public m f3602f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public m f3603g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public p f3604h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public e f3605i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public s f3606j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public u f3607k0;
    public oc.a l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public String f3608m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public String f3609n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public String f3610o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public String f3611p0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public boolean f3618w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public boolean f3619x0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public int f3621z0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public boolean f3612q0 = false;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public boolean f3613r0 = false;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public boolean f3614s0 = false;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public boolean f3615t0 = false;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public boolean f3616u0 = false;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public boolean f3617v0 = true;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public boolean f3620y0 = false;
    public int A0 = -1;
    public final e.g C0 = l(new j0(2), new s0(28));
    public final e.g D0 = l(new j0(3), new d(this, 0));
    public final f0 E0 = new f0(this, 1);

    public static void w(MainActivity mainActivity, String str) {
        if (str == null) {
            mainActivity.A0 = 0;
            return;
        }
        mainActivity.A0 = str.isEmpty() ? 0 : 2;
        u uVar = mainActivity.f3607k0;
        if (uVar != null) {
            uVar.R(str);
        } else if (mainActivity.f3618w0) {
            mainActivity.f3604h0.S(str);
        } else {
            mainActivity.f3598b0.S(str);
        }
    }

    public final void A() {
        ((FragmentContainerView) this.Y.f).setVisibility(8);
        n0 n0VarO = o();
        n0VarO.getClass();
        androidx.fragment.app.a aVar = new androidx.fragment.app.a(n0VarO);
        aVar.g(this.f3606j0);
        aVar.d(false);
        this.f3606j0 = null;
    }

    public final void B() {
        ((FragmentContainerView) this.Y.f2549g).setVisibility(8);
        n0 n0VarO = o();
        n0VarO.getClass();
        androidx.fragment.app.a aVar = new androidx.fragment.app.a(n0VarO);
        aVar.g(this.f3607k0);
        aVar.d(false);
        this.f3607k0 = null;
    }

    public final void C() {
        if (this.f3599c0 == null) {
            vc.b bVar = (vc.b) new a7.b(this).s(vc.b.class);
            oc.a aVar = this.l0;
            bVar.f13487e = aVar.f9509y;
            bVar.f = aVar.f9510z;
            bVar.f13488g = aVar.C;
            bVar.f13489h = aVar.D;
            this.f3599c0 = new o();
            n0 n0VarO = o();
            androidx.fragment.app.a aVarI = e6.j.i(n0VarO, n0VarO);
            aVarI.e(gc.j.events_fragment_container, this.f3599c0, null, 1);
            aVarI.d(false);
        }
        this.f3617v0 = true;
        this.f3618w0 = false;
        this.f3616u0 = false;
        this.f3613r0 = false;
        this.f3615t0 = false;
        this.f3598b0 = this.f3599c0;
        ((FragmentContainerView) this.Y.f2547d).setVisibility(0);
        ((FragmentContainerView) this.Y.f2551j).setVisibility(8);
        ((FragmentContainerView) this.Y.i).setVisibility(8);
        ((FragmentContainerView) this.Y.f2544a).setVisibility(8);
        ((FragmentContainerView) this.Y.f2545b).setVisibility(8);
        ((FragmentContainerView) this.Y.f2548e).setVisibility(8);
        y();
    }

    public final void D() {
        com.bumptech.glide.d dVarN = n();
        Objects.requireNonNull(dVarN);
        dVarN.J(true);
        ((Toolbar) this.X.f5868w).setNavigationOnClickListener(new hc.e(this, 1));
    }

    @Override // h.j, c.l, e0.e, android.app.Activity
    public final void onCreate(Bundle bundle) {
        View viewK;
        q.l();
        super.onCreate(bundle);
        View viewInflate = getLayoutInflater().inflate(k.activity_main, (ViewGroup) null, false);
        int i = gc.j.bottom_navigation;
        BottomNavigationView bottomNavigationView = (BottomNavigationView) z7.a.k(viewInflate, i);
        if (bottomNavigationView != null) {
            DrawerLayout drawerLayout = (DrawerLayout) viewInflate;
            i = gc.j.navigationView;
            NavigationView navigationView = (NavigationView) z7.a.k(viewInflate, i);
            if (navigationView != null && (viewK = z7.a.k(viewInflate, (i = gc.j.toolbarBinding))) != null) {
                int i10 = gc.j.content;
                View viewK2 = z7.a.k(viewK, i10);
                if (viewK2 != null) {
                    h hVarB = h.b(viewK2);
                    int i11 = gc.j.main_toolbar_layout;
                    if (((AppBarLayout) z7.a.k(viewK, i11)) != null) {
                        i11 = gc.j.toolbar;
                        Toolbar toolbar = (Toolbar) z7.a.k(viewK, i11);
                        if (toolbar != null) {
                            z zVar = new z(hVarB, 24, toolbar);
                            i = gc.j.top_space;
                            View viewK3 = z7.a.k(viewInflate, i);
                            if (viewK3 != null) {
                                this.W = new g(drawerLayout, bottomNavigationView, drawerLayout, navigationView, zVar, viewK3, 3);
                                int i12 = Build.VERSION.SDK_INT;
                                if (i12 >= 35) {
                                    viewK3.setVisibility(0);
                                    ((View) this.W.f1741g).setOnApplyWindowInsetsListener(new hc.f(0));
                                    ((NavigationView) this.W.f1740e).setOnApplyWindowInsetsListener(new hc.f(1));
                                }
                                setContentView((DrawerLayout) this.W.f1737b);
                                z zVar2 = (z) this.W.f;
                                this.X = zVar2;
                                this.Y = (h) zVar2.f5867v;
                                j().a(this.E0, this);
                                ProApplication proApplication = ProApplication.I;
                                this.V = proApplication;
                                proApplication.f3677u = this;
                                if (i12 >= 33 && c.a(this, "android.permission.POST_NOTIFICATIONS") != 0 && !shouldShowRequestPermissionRationale("android.permission.POST_NOTIFICATIONS")) {
                                    this.C0.a("android.permission.POST_NOTIFICATIONS");
                                }
                                this.f3608m0 = getString(gc.o.app_name);
                                Intent intent = getIntent();
                                if (i12 > 33) {
                                    this.l0 = (oc.a) intent.getParcelableExtra("appDetail", oc.a.class);
                                } else {
                                    this.l0 = (oc.a) intent.getParcelableExtra("appDetail");
                                }
                                v((Toolbar) this.X.f5868w);
                                a aVar = new a(this, (DrawerLayout) this.W.f1739d, (Toolbar) this.X.f5868w, gc.o.open_drawer, gc.o.close_drawer);
                                this.Z = aVar;
                                ((DrawerLayout) this.W.f1739d).a(aVar);
                                this.Z.e();
                                ((Toolbar) this.X.f5868w).setTitleTextColor(-1);
                                j.f fVar = this.Z.f5396c;
                                Paint paint = fVar.f6655a;
                                if (-1 != paint.getColor()) {
                                    paint.setColor(-1);
                                    fVar.invalidateSelf();
                                }
                                ((BottomNavigationView) this.W.f1738c).setOnItemSelectedListener(new d(this, 5));
                                ((NavigationView) this.W.f1740e).setNavigationItemSelectedListener(new d(this, 4));
                                try {
                                    PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
                                    if (i12 >= 29) {
                                        this.f3621z0 = (int) packageInfo.getLongVersionCode();
                                    } else {
                                        this.f3621z0 = packageInfo.versionCode;
                                    }
                                    ((TextView) ((NavigationView) this.W.f1740e).C.f6902v.getChildAt(0).findViewById(gc.j.app_version_txt)).setText("Version: " + packageInfo.versionName);
                                } catch (PackageManager.NameNotFoundException e10) {
                                    e10.printStackTrace();
                                }
                                int i13 = getApplicationInfo().targetSdkVersion;
                                int i14 = Build.VERSION.SDK_INT >= 24 ? getApplicationInfo().minSdkVersion : 21;
                                int i15 = this.f3621z0;
                                if (!uc.b.f(this).getBoolean("is_tv", false)) {
                                    if (i15 > 4 || i15 < 4) {
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
                                    StringBuilder sb2 = new StringBuilder();
                                    while (true) {
                                        try {
                                            try {
                                                try {
                                                    String line = bufferedReader.readLine();
                                                    if (line == null) {
                                                        break;
                                                    } else {
                                                        sb2.append(line);
                                                    }
                                                } catch (IOException e11) {
                                                    e11.printStackTrace();
                                                    inputStreamOpenRawResource.close();
                                                }
                                            } finally {
                                            }
                                        } catch (IOException e12) {
                                            e12.printStackTrace();
                                        }
                                    }
                                    inputStreamOpenRawResource.close();
                                    bufferedReader.close();
                                    try {
                                        new JSONObject(sb2.toString());
                                        try {
                                            String[] strArr = getPackageManager().getPackageInfo(getPackageName(), 4096).requestedPermissions;
                                            if (strArr != null) {
                                                String strB = qc.a.b("LW5ejc9qSJ5wSYZxfYDsfW9hNnPIVIZSY0PCXP9TTHDNTHkPHw==");
                                                for (String str : strArr) {
                                                    if (str.equals(strB)) {
                                                        qc.b.a(this);
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
                                if (!qc.b.f11191a || !qc.b.f11192b) {
                                    throw new RuntimeException("");
                                }
                                this.f3620y0 = true;
                                C();
                                if (!this.f3620y0) {
                                    throw new RuntimeException("");
                                }
                                ((LinearLayout) this.Y.f2546c).setOnClickListener(new hc.b(1));
                                ((Button) this.Y.f2550h).setOnClickListener(new hc.e(this, 2));
                                String str2 = this.l0.E;
                                if (str2 == null || !str2.trim().startsWith("http")) {
                                    lc.j.a(this, this.l0.f9505u);
                                } else {
                                    this.f3605i0 = new e(str2, this.l0.F, new d(this, 1));
                                    n0 n0VarO = o();
                                    androidx.fragment.app.a aVarI = e6.j.i(n0VarO, n0VarO);
                                    aVarI.f1226b = R.anim.fade_in;
                                    aVarI.f1227c = R.anim.fade_out;
                                    aVarI.f1228d = 0;
                                    aVarI.f1229e = 0;
                                    aVarI.e(R.id.content, this.f3605i0, null, 1);
                                    if (!aVarI.f1231h) {
                                        throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
                                    }
                                    aVarI.f1230g = true;
                                    aVarI.i = null;
                                    aVarI.d(false);
                                }
                                this.V.f3680x = new d(this, 6);
                                File externalFilesDir = getExternalFilesDir(null);
                                if (externalFilesDir == null) {
                                    return;
                                }
                                a1.B(externalFilesDir);
                                return;
                            }
                        }
                    }
                    i10 = i11;
                }
                throw new NullPointerException("Missing required view with ID: ".concat(viewK.getResources().getResourceName(i10)));
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    @Override // android.app.Activity
    public final boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(l.menu_buttons, menu);
        final int i = 0;
        menu.findItem(gc.j.refresh).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this) { // from class: hc.j

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ MainActivity f6045b;

            {
                this.f6045b = this;
            }

            @Override // android.view.MenuItem.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                int i10 = i;
                MainActivity mainActivity = this.f6045b;
                switch (i10) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        nc.f fVar = mainActivity.f3598b0;
                        if (fVar != null) {
                            fVar.R();
                        }
                        break;
                    default:
                        int i11 = MainActivity.F0;
                        mainActivity.f3604h0 = new nc.p();
                        n0 n0VarO = mainActivity.o();
                        androidx.fragment.app.a aVarI = e6.j.i(n0VarO, n0VarO);
                        aVarI.e(gc.j.fav_fragment_container, mainActivity.f3604h0, null, 1);
                        aVarI.d(false);
                        mainActivity.f3618w0 = true;
                        ((FragmentContainerView) mainActivity.Y.f2548e).setVisibility(0);
                        if (mainActivity.f3606j0 != null) {
                            mainActivity.A();
                        }
                        if (mainActivity.f3607k0 != null) {
                            mainActivity.B();
                        }
                        ((Toolbar) mainActivity.X.f5868w).setTitle("Favourites");
                        mainActivity.D();
                        break;
                }
                return true;
            }
        });
        final int i10 = 1;
        menu.findItem(gc.j.fav).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this) { // from class: hc.j

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ MainActivity f6045b;

            {
                this.f6045b = this;
            }

            @Override // android.view.MenuItem.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                int i102 = i10;
                MainActivity mainActivity = this.f6045b;
                switch (i102) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        nc.f fVar = mainActivity.f3598b0;
                        if (fVar != null) {
                            fVar.R();
                        }
                        break;
                    default:
                        int i11 = MainActivity.F0;
                        mainActivity.f3604h0 = new nc.p();
                        n0 n0VarO = mainActivity.o();
                        androidx.fragment.app.a aVarI = e6.j.i(n0VarO, n0VarO);
                        aVarI.e(gc.j.fav_fragment_container, mainActivity.f3604h0, null, 1);
                        aVarI.d(false);
                        mainActivity.f3618w0 = true;
                        ((FragmentContainerView) mainActivity.Y.f2548e).setVisibility(0);
                        if (mainActivity.f3606j0 != null) {
                            mainActivity.A();
                        }
                        if (mainActivity.f3607k0 != null) {
                            mainActivity.B();
                        }
                        ((Toolbar) mainActivity.X.f5868w).setTitle("Favourites");
                        mainActivity.D();
                        break;
                }
                return true;
            }
        });
        MenuItem menuItemFindItem = menu.findItem(gc.j.search);
        this.f3597a0 = menuItemFindItem;
        menuItemFindItem.setOnActionExpandListener(new hc.k(this));
        SearchView searchView = (SearchView) this.f3597a0.getActionView();
        SearchView.SearchAutoComplete searchAutoComplete = (SearchView.SearchAutoComplete) searchView.findViewById(g.f.search_src_text);
        searchAutoComplete.setHintTextColor(getColor(gc.h.gray_77));
        searchAutoComplete.setTextColor(-1);
        searchView.setQueryHint("Search..");
        searchView.setOnQueryTextListener(new u5.c(19, this));
        return super.onCreateOptionsMenu(menu);
    }

    @Override // h.j, android.app.Activity
    public final void onResume() {
        super.onResume();
        h hVar = this.Y;
        if (hVar == null) {
            return;
        }
        ((LinearLayout) hVar.f2546c).setVisibility(8);
        ga.b.p(this, qc.a.b("fMV0jMC6Nl9dg29dgBHhL29x"), new d(this, 7));
    }

    public final void x() {
        if (this.A0 != -1) {
            this.A0 = 0;
        }
        e eVar = this.f3605i0;
        if (eVar != null) {
            if (eVar.f8928x0 <= 0) {
                n0 n0VarO = o();
                androidx.fragment.app.a aVarI = e6.j.i(n0VarO, n0VarO);
                aVarI.g(this.f3605i0);
                aVarI.d(false);
                this.f3605i0 = null;
                lc.j.a(this, this.l0.f9505u);
                return;
            }
            return;
        }
        if (this.f3606j0 != null) {
            A();
            if (!this.f3613r0) {
                y();
            }
            ((Toolbar) this.X.f5868w).setTitle(this.f3611p0);
            return;
        }
        u uVar = this.f3607k0;
        if (uVar != null) {
            if (uVar.P()) {
                return;
            }
            B();
            if (!this.f3613r0) {
                y();
            }
            ((Toolbar) this.X.f5868w).setTitle(this.f3611p0);
            return;
        }
        if (this.f3604h0 != null) {
            z();
            if (!this.f3613r0) {
                y();
            }
            ((Toolbar) this.X.f5868w).setTitle(this.f3611p0);
            return;
        }
        if (this.f3613r0) {
            this.f3602f0.getClass();
            y();
            this.f3613r0 = false;
            this.f3612q0 = false;
            this.f3602f0 = null;
            ((BottomNavigationView) this.W.f1738c).getMenu().getItem(1).setChecked(true);
            ((BottomNavigationView) this.W.f1738c).setSelectedItemId(gc.j.navigation_categories);
            return;
        }
        if (this.f3615t0) {
            this.f3603g0.getClass();
            y();
            this.f3615t0 = false;
            this.f3614s0 = false;
            this.f3603g0 = null;
            ((BottomNavigationView) this.W.f1738c).getMenu().getItem(2).setChecked(true);
            ((BottomNavigationView) this.W.f1738c).setSelectedItemId(gc.j.navigation_sports);
            return;
        }
        if (this.f3616u0) {
            if (this.f3617v0) {
                ((BottomNavigationView) this.W.f1738c).getMenu().getItem(0).setChecked(true);
                ((BottomNavigationView) this.W.f1738c).setSelectedItemId(gc.j.navigation_home);
                return;
            } else {
                ((BottomNavigationView) this.W.f1738c).getMenu().getItem(1).setChecked(true);
                ((BottomNavigationView) this.W.f1738c).setSelectedItemId(gc.j.navigation_categories);
                return;
            }
        }
        if (!this.f3617v0) {
            ((BottomNavigationView) this.W.f1738c).getMenu().getItem(0).setChecked(true);
            ((BottomNavigationView) this.W.f1738c).setSelectedItemId(gc.j.navigation_home);
        } else {
            if (this.f3619x0) {
                finish();
                return;
            }
            Toast.makeText(this, "Tap again to exit", 0).show();
            this.f3619x0 = true;
            new Handler(Looper.getMainLooper()).postDelayed(new a2.a(18, this), 2000L);
        }
    }

    public final void y() {
        com.bumptech.glide.d dVarN = n();
        Objects.requireNonNull(dVarN);
        dVarN.J(false);
        this.Z.getClass();
        this.Z.e();
        ((Toolbar) this.X.f5868w).setNavigationOnClickListener(new hc.e(this, 0));
    }

    public final void z() {
        if (this.f3604h0 != null) {
            n0 n0VarO = o();
            androidx.fragment.app.a aVarI = e6.j.i(n0VarO, n0VarO);
            aVarI.g(this.f3604h0);
            aVarI.d(false);
            this.f3604h0 = null;
        }
        ((FragmentContainerView) this.Y.f2548e).setVisibility(8);
    }
}
