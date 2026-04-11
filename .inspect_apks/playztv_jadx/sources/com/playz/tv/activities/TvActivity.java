package com.playz.tv.activities;

import android.R;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.f0;
import androidx.fragment.app.n0;
import androidx.media3.decoder.DecoderInputBuffer;
import c7.h;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.navigation.NavigationView;
import com.playz.tv.activities.TvActivity;
import com.playz.tv.app.ProApplication;
import gc.k;
import h.j;
import h.q;
import hc.t;
import hc.v;
import java.io.File;
import n.a1;
import nc.e;
import nc.f;
import nc.m;
import nc.p;
import nc.s;
import nc.u;
import oc.a;
import ub.o;
import vc.b;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class TvActivity extends j {

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public static final /* synthetic */ int f3654x0 = 0;
    public ProApplication V;
    public o W;
    public h X;
    public h Y;
    public f Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public nc.o f3655a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public nc.h f3656b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public nc.h f3657c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public m f3658d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public m f3659e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public p f3660f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public e f3661g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public s f3662h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public u f3663i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public a f3664j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public String f3665k0;
    public String l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public String f3666m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public String f3667n0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public boolean f3674u0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public boolean f3668o0 = false;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public boolean f3669p0 = false;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public boolean f3670q0 = false;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public boolean f3671r0 = false;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public boolean f3672s0 = false;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public boolean f3673t0 = true;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public int f3675v0 = -1;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public final f0 f3676w0 = new f0(this, 3);

    @Override // h.j, c.l, e0.e, android.app.Activity
    public final void onCreate(Bundle bundle) {
        View viewK;
        q.l();
        super.onCreate(bundle);
        View viewInflate = getLayoutInflater().inflate(k.activity_tv, (ViewGroup) null, false);
        int i = gc.j.content_binding;
        View viewK2 = z7.a.k(viewInflate, i);
        if (viewK2 != null) {
            h hVarB = h.b(viewK2);
            DrawerLayout drawerLayout = (DrawerLayout) viewInflate;
            i = gc.j.navigationView;
            NavigationView navigationView = (NavigationView) z7.a.k(viewInflate, i);
            if (navigationView != null && (viewK = z7.a.k(viewInflate, (i = gc.j.top_binding))) != null) {
                int i10 = gc.j.cats_btn;
                MaterialButton materialButton = (MaterialButton) z7.a.k(viewK, i10);
                if (materialButton != null) {
                    i10 = gc.j.events_btn;
                    MaterialButton materialButton2 = (MaterialButton) z7.a.k(viewK, i10);
                    if (materialButton2 != null) {
                        i10 = gc.j.fav_btn;
                        ImageButton imageButton = (ImageButton) z7.a.k(viewK, i10);
                        if (imageButton != null) {
                            i10 = gc.j.menu_btn;
                            ImageButton imageButton2 = (ImageButton) z7.a.k(viewK, i10);
                            if (imageButton2 != null) {
                                i10 = gc.j.refresh_btn;
                                ImageButton imageButton3 = (ImageButton) z7.a.k(viewK, i10);
                                if (imageButton3 != null) {
                                    i10 = gc.j.search_btn;
                                    ImageButton imageButton4 = (ImageButton) z7.a.k(viewK, i10);
                                    if (imageButton4 != null) {
                                        i10 = gc.j.search_img;
                                        ImageView imageView = (ImageView) z7.a.k(viewK, i10);
                                        if (imageView != null) {
                                            i10 = gc.j.search_view;
                                            EditText editText = (EditText) z7.a.k(viewK, i10);
                                            if (editText != null) {
                                                i10 = gc.j.sports_btn;
                                                MaterialButton materialButton3 = (MaterialButton) z7.a.k(viewK, i10);
                                                if (materialButton3 != null) {
                                                    i10 = gc.j.title_txt;
                                                    TextView textView = (TextView) z7.a.k(viewK, i10);
                                                    if (textView != null) {
                                                        this.W = new o(drawerLayout, hVarB, drawerLayout, navigationView, new h(materialButton, materialButton2, imageButton, imageButton2, imageButton3, imageButton4, imageView, editText, materialButton3, textView), 19);
                                                        setContentView(drawerLayout);
                                                        o oVar = this.W;
                                                        this.X = (h) oVar.f12871y;
                                                        this.Y = (h) oVar.f12868v;
                                                        j().a(this.f3676w0, this);
                                                        ProApplication proApplication = ProApplication.I;
                                                        this.V = proApplication;
                                                        proApplication.f3677u = this;
                                                        this.f3665k0 = getString(gc.o.app_name);
                                                        Intent intent = getIntent();
                                                        if (Build.VERSION.SDK_INT > 33) {
                                                            this.f3664j0 = (a) intent.getParcelableExtra("appDetail", a.class);
                                                        } else {
                                                            this.f3664j0 = (a) intent.getParcelableExtra("appDetail");
                                                        }
                                                        w();
                                                        ((MaterialButton) this.X.f2545b).requestFocus();
                                                        final int i11 = 0;
                                                        ((ImageButton) this.X.f2547d).setOnClickListener(new View.OnClickListener(this) { // from class: hc.s

                                                            /* JADX INFO: renamed from: v, reason: collision with root package name */
                                                            public final /* synthetic */ TvActivity f6061v;

                                                            {
                                                                this.f6061v = this;
                                                            }

                                                            @Override // android.view.View.OnClickListener
                                                            public final void onClick(View view) {
                                                                int i12 = i11;
                                                                TvActivity tvActivity = this.f6061v;
                                                                switch (i12) {
                                                                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                                                        ((DrawerLayout) tvActivity.W.f12869w).r();
                                                                        break;
                                                                    case 1:
                                                                        int i13 = TvActivity.f3654x0;
                                                                        tvActivity.z();
                                                                        break;
                                                                    case 2:
                                                                        if (tvActivity.f3656b0 == null) {
                                                                            ((vc.a) new a7.b(tvActivity).t(vc.a.class, "categories")).f13484d = new t(tvActivity, 4);
                                                                            tvActivity.f3656b0 = nc.h.U("categories");
                                                                            n0 n0VarO = tvActivity.o();
                                                                            androidx.fragment.app.a aVarI = e6.j.i(n0VarO, n0VarO);
                                                                            aVarI.e(gc.j.categories_fragment_container, tvActivity.f3656b0, null, 1);
                                                                            aVarI.d(false);
                                                                        }
                                                                        tvActivity.f3674u0 = false;
                                                                        tvActivity.f3673t0 = false;
                                                                        tvActivity.f3672s0 = false;
                                                                        ((FragmentContainerView) tvActivity.Y.f2547d).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Y.f2551j).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Y.i).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Y.f2548e).setVisibility(8);
                                                                        tvActivity.f3667n0 = "Categories";
                                                                        ((TextView) tvActivity.X.f2551j).setText("Categories");
                                                                        if (!tvActivity.f3668o0 || tvActivity.f3669p0) {
                                                                            tvActivity.f3669p0 = false;
                                                                            tvActivity.f3668o0 = false;
                                                                            tvActivity.Z = tvActivity.f3656b0;
                                                                            ((FragmentContainerView) tvActivity.Y.f2544a).setVisibility(0);
                                                                            ((FragmentContainerView) tvActivity.Y.f2545b).setVisibility(8);
                                                                        } else {
                                                                            tvActivity.f3669p0 = true;
                                                                            nc.m mVar = tvActivity.f3658d0;
                                                                            tvActivity.Z = mVar;
                                                                            tvActivity.V.B = mVar.f8946v0;
                                                                            ((TextView) tvActivity.X.f2551j).setText(tvActivity.l0);
                                                                            ((FragmentContainerView) tvActivity.Y.f2544a).setVisibility(8);
                                                                            ((FragmentContainerView) tvActivity.Y.f2545b).setVisibility(0);
                                                                        }
                                                                        if (tvActivity.f3675v0 == 0) {
                                                                            tvActivity.f3656b0.S("");
                                                                        }
                                                                        break;
                                                                    case 3:
                                                                        if (tvActivity.f3657c0 == null) {
                                                                            vc.a aVar = (vc.a) new a7.b(tvActivity).t(vc.a.class, "sports");
                                                                            aVar.f13485e = true;
                                                                            aVar.f13484d = new t(tvActivity, 2);
                                                                            tvActivity.f3657c0 = nc.h.U("sports");
                                                                            n0 n0VarO2 = tvActivity.o();
                                                                            androidx.fragment.app.a aVarI2 = e6.j.i(n0VarO2, n0VarO2);
                                                                            aVarI2.e(gc.j.sports_fragment_container, tvActivity.f3657c0, null, 1);
                                                                            aVarI2.d(false);
                                                                        }
                                                                        tvActivity.f3674u0 = false;
                                                                        tvActivity.f3673t0 = false;
                                                                        tvActivity.f3669p0 = false;
                                                                        tvActivity.f3672s0 = true;
                                                                        ((FragmentContainerView) tvActivity.Y.f2547d).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Y.f2544a).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Y.f2545b).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Y.f2548e).setVisibility(8);
                                                                        tvActivity.f3667n0 = "Sports";
                                                                        ((TextView) tvActivity.X.f2551j).setText("Sports");
                                                                        if (!tvActivity.f3670q0 || tvActivity.f3671r0) {
                                                                            tvActivity.f3671r0 = false;
                                                                            tvActivity.f3670q0 = false;
                                                                            tvActivity.Z = tvActivity.f3657c0;
                                                                            ((FragmentContainerView) tvActivity.Y.f2551j).setVisibility(0);
                                                                            ((FragmentContainerView) tvActivity.Y.i).setVisibility(8);
                                                                        } else {
                                                                            tvActivity.f3671r0 = true;
                                                                            nc.m mVar2 = tvActivity.f3659e0;
                                                                            tvActivity.Z = mVar2;
                                                                            tvActivity.V.B = mVar2.f8946v0;
                                                                            ((TextView) tvActivity.X.f2551j).setText(tvActivity.f3666m0);
                                                                            ((FragmentContainerView) tvActivity.Y.f2551j).setVisibility(8);
                                                                            ((FragmentContainerView) tvActivity.Y.i).setVisibility(0);
                                                                        }
                                                                        if (tvActivity.f3675v0 == 0) {
                                                                            tvActivity.f3656b0.S("");
                                                                        }
                                                                        break;
                                                                    case b1.j.LONG_FIELD_NUMBER /* 4 */:
                                                                        ((ImageView) tvActivity.X.f2549g).setVisibility(0);
                                                                        ((EditText) tvActivity.X.f2550h).setVisibility(0);
                                                                        ((EditText) tvActivity.X.f2550h).setFocusable(true);
                                                                        ((EditText) tvActivity.X.f2550h).requestFocus();
                                                                        ((InputMethodManager) tvActivity.getSystemService("input_method")).showSoftInput((EditText) tvActivity.X.f2550h, 1);
                                                                        break;
                                                                    case b1.j.STRING_FIELD_NUMBER /* 5 */:
                                                                        int i14 = TvActivity.f3654x0;
                                                                        tvActivity.f3660f0 = new nc.p();
                                                                        n0 n0VarO3 = tvActivity.o();
                                                                        androidx.fragment.app.a aVarI3 = e6.j.i(n0VarO3, n0VarO3);
                                                                        aVarI3.e(gc.j.fav_fragment_container, tvActivity.f3660f0, null, 1);
                                                                        aVarI3.d(false);
                                                                        tvActivity.f3674u0 = true;
                                                                        ((FragmentContainerView) tvActivity.Y.f2548e).setVisibility(0);
                                                                        if (tvActivity.f3662h0 != null) {
                                                                            tvActivity.x();
                                                                        }
                                                                        if (tvActivity.f3663i0 != null) {
                                                                            tvActivity.y();
                                                                        }
                                                                        ((TextView) tvActivity.X.f2551j).setText("Favourites");
                                                                        break;
                                                                    default:
                                                                        nc.f fVar = tvActivity.Z;
                                                                        if (fVar != null) {
                                                                            fVar.R();
                                                                        }
                                                                        break;
                                                                }
                                                            }
                                                        });
                                                        final int i12 = 1;
                                                        ((MaterialButton) this.X.f2545b).setOnClickListener(new View.OnClickListener(this) { // from class: hc.s

                                                            /* JADX INFO: renamed from: v, reason: collision with root package name */
                                                            public final /* synthetic */ TvActivity f6061v;

                                                            {
                                                                this.f6061v = this;
                                                            }

                                                            @Override // android.view.View.OnClickListener
                                                            public final void onClick(View view) {
                                                                int i122 = i12;
                                                                TvActivity tvActivity = this.f6061v;
                                                                switch (i122) {
                                                                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                                                        ((DrawerLayout) tvActivity.W.f12869w).r();
                                                                        break;
                                                                    case 1:
                                                                        int i13 = TvActivity.f3654x0;
                                                                        tvActivity.z();
                                                                        break;
                                                                    case 2:
                                                                        if (tvActivity.f3656b0 == null) {
                                                                            ((vc.a) new a7.b(tvActivity).t(vc.a.class, "categories")).f13484d = new t(tvActivity, 4);
                                                                            tvActivity.f3656b0 = nc.h.U("categories");
                                                                            n0 n0VarO = tvActivity.o();
                                                                            androidx.fragment.app.a aVarI = e6.j.i(n0VarO, n0VarO);
                                                                            aVarI.e(gc.j.categories_fragment_container, tvActivity.f3656b0, null, 1);
                                                                            aVarI.d(false);
                                                                        }
                                                                        tvActivity.f3674u0 = false;
                                                                        tvActivity.f3673t0 = false;
                                                                        tvActivity.f3672s0 = false;
                                                                        ((FragmentContainerView) tvActivity.Y.f2547d).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Y.f2551j).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Y.i).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Y.f2548e).setVisibility(8);
                                                                        tvActivity.f3667n0 = "Categories";
                                                                        ((TextView) tvActivity.X.f2551j).setText("Categories");
                                                                        if (!tvActivity.f3668o0 || tvActivity.f3669p0) {
                                                                            tvActivity.f3669p0 = false;
                                                                            tvActivity.f3668o0 = false;
                                                                            tvActivity.Z = tvActivity.f3656b0;
                                                                            ((FragmentContainerView) tvActivity.Y.f2544a).setVisibility(0);
                                                                            ((FragmentContainerView) tvActivity.Y.f2545b).setVisibility(8);
                                                                        } else {
                                                                            tvActivity.f3669p0 = true;
                                                                            nc.m mVar = tvActivity.f3658d0;
                                                                            tvActivity.Z = mVar;
                                                                            tvActivity.V.B = mVar.f8946v0;
                                                                            ((TextView) tvActivity.X.f2551j).setText(tvActivity.l0);
                                                                            ((FragmentContainerView) tvActivity.Y.f2544a).setVisibility(8);
                                                                            ((FragmentContainerView) tvActivity.Y.f2545b).setVisibility(0);
                                                                        }
                                                                        if (tvActivity.f3675v0 == 0) {
                                                                            tvActivity.f3656b0.S("");
                                                                        }
                                                                        break;
                                                                    case 3:
                                                                        if (tvActivity.f3657c0 == null) {
                                                                            vc.a aVar = (vc.a) new a7.b(tvActivity).t(vc.a.class, "sports");
                                                                            aVar.f13485e = true;
                                                                            aVar.f13484d = new t(tvActivity, 2);
                                                                            tvActivity.f3657c0 = nc.h.U("sports");
                                                                            n0 n0VarO2 = tvActivity.o();
                                                                            androidx.fragment.app.a aVarI2 = e6.j.i(n0VarO2, n0VarO2);
                                                                            aVarI2.e(gc.j.sports_fragment_container, tvActivity.f3657c0, null, 1);
                                                                            aVarI2.d(false);
                                                                        }
                                                                        tvActivity.f3674u0 = false;
                                                                        tvActivity.f3673t0 = false;
                                                                        tvActivity.f3669p0 = false;
                                                                        tvActivity.f3672s0 = true;
                                                                        ((FragmentContainerView) tvActivity.Y.f2547d).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Y.f2544a).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Y.f2545b).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Y.f2548e).setVisibility(8);
                                                                        tvActivity.f3667n0 = "Sports";
                                                                        ((TextView) tvActivity.X.f2551j).setText("Sports");
                                                                        if (!tvActivity.f3670q0 || tvActivity.f3671r0) {
                                                                            tvActivity.f3671r0 = false;
                                                                            tvActivity.f3670q0 = false;
                                                                            tvActivity.Z = tvActivity.f3657c0;
                                                                            ((FragmentContainerView) tvActivity.Y.f2551j).setVisibility(0);
                                                                            ((FragmentContainerView) tvActivity.Y.i).setVisibility(8);
                                                                        } else {
                                                                            tvActivity.f3671r0 = true;
                                                                            nc.m mVar2 = tvActivity.f3659e0;
                                                                            tvActivity.Z = mVar2;
                                                                            tvActivity.V.B = mVar2.f8946v0;
                                                                            ((TextView) tvActivity.X.f2551j).setText(tvActivity.f3666m0);
                                                                            ((FragmentContainerView) tvActivity.Y.f2551j).setVisibility(8);
                                                                            ((FragmentContainerView) tvActivity.Y.i).setVisibility(0);
                                                                        }
                                                                        if (tvActivity.f3675v0 == 0) {
                                                                            tvActivity.f3656b0.S("");
                                                                        }
                                                                        break;
                                                                    case b1.j.LONG_FIELD_NUMBER /* 4 */:
                                                                        ((ImageView) tvActivity.X.f2549g).setVisibility(0);
                                                                        ((EditText) tvActivity.X.f2550h).setVisibility(0);
                                                                        ((EditText) tvActivity.X.f2550h).setFocusable(true);
                                                                        ((EditText) tvActivity.X.f2550h).requestFocus();
                                                                        ((InputMethodManager) tvActivity.getSystemService("input_method")).showSoftInput((EditText) tvActivity.X.f2550h, 1);
                                                                        break;
                                                                    case b1.j.STRING_FIELD_NUMBER /* 5 */:
                                                                        int i14 = TvActivity.f3654x0;
                                                                        tvActivity.f3660f0 = new nc.p();
                                                                        n0 n0VarO3 = tvActivity.o();
                                                                        androidx.fragment.app.a aVarI3 = e6.j.i(n0VarO3, n0VarO3);
                                                                        aVarI3.e(gc.j.fav_fragment_container, tvActivity.f3660f0, null, 1);
                                                                        aVarI3.d(false);
                                                                        tvActivity.f3674u0 = true;
                                                                        ((FragmentContainerView) tvActivity.Y.f2548e).setVisibility(0);
                                                                        if (tvActivity.f3662h0 != null) {
                                                                            tvActivity.x();
                                                                        }
                                                                        if (tvActivity.f3663i0 != null) {
                                                                            tvActivity.y();
                                                                        }
                                                                        ((TextView) tvActivity.X.f2551j).setText("Favourites");
                                                                        break;
                                                                    default:
                                                                        nc.f fVar = tvActivity.Z;
                                                                        if (fVar != null) {
                                                                            fVar.R();
                                                                        }
                                                                        break;
                                                                }
                                                            }
                                                        });
                                                        final int i13 = 2;
                                                        ((MaterialButton) this.X.f2544a).setOnClickListener(new View.OnClickListener(this) { // from class: hc.s

                                                            /* JADX INFO: renamed from: v, reason: collision with root package name */
                                                            public final /* synthetic */ TvActivity f6061v;

                                                            {
                                                                this.f6061v = this;
                                                            }

                                                            @Override // android.view.View.OnClickListener
                                                            public final void onClick(View view) {
                                                                int i122 = i13;
                                                                TvActivity tvActivity = this.f6061v;
                                                                switch (i122) {
                                                                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                                                        ((DrawerLayout) tvActivity.W.f12869w).r();
                                                                        break;
                                                                    case 1:
                                                                        int i132 = TvActivity.f3654x0;
                                                                        tvActivity.z();
                                                                        break;
                                                                    case 2:
                                                                        if (tvActivity.f3656b0 == null) {
                                                                            ((vc.a) new a7.b(tvActivity).t(vc.a.class, "categories")).f13484d = new t(tvActivity, 4);
                                                                            tvActivity.f3656b0 = nc.h.U("categories");
                                                                            n0 n0VarO = tvActivity.o();
                                                                            androidx.fragment.app.a aVarI = e6.j.i(n0VarO, n0VarO);
                                                                            aVarI.e(gc.j.categories_fragment_container, tvActivity.f3656b0, null, 1);
                                                                            aVarI.d(false);
                                                                        }
                                                                        tvActivity.f3674u0 = false;
                                                                        tvActivity.f3673t0 = false;
                                                                        tvActivity.f3672s0 = false;
                                                                        ((FragmentContainerView) tvActivity.Y.f2547d).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Y.f2551j).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Y.i).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Y.f2548e).setVisibility(8);
                                                                        tvActivity.f3667n0 = "Categories";
                                                                        ((TextView) tvActivity.X.f2551j).setText("Categories");
                                                                        if (!tvActivity.f3668o0 || tvActivity.f3669p0) {
                                                                            tvActivity.f3669p0 = false;
                                                                            tvActivity.f3668o0 = false;
                                                                            tvActivity.Z = tvActivity.f3656b0;
                                                                            ((FragmentContainerView) tvActivity.Y.f2544a).setVisibility(0);
                                                                            ((FragmentContainerView) tvActivity.Y.f2545b).setVisibility(8);
                                                                        } else {
                                                                            tvActivity.f3669p0 = true;
                                                                            nc.m mVar = tvActivity.f3658d0;
                                                                            tvActivity.Z = mVar;
                                                                            tvActivity.V.B = mVar.f8946v0;
                                                                            ((TextView) tvActivity.X.f2551j).setText(tvActivity.l0);
                                                                            ((FragmentContainerView) tvActivity.Y.f2544a).setVisibility(8);
                                                                            ((FragmentContainerView) tvActivity.Y.f2545b).setVisibility(0);
                                                                        }
                                                                        if (tvActivity.f3675v0 == 0) {
                                                                            tvActivity.f3656b0.S("");
                                                                        }
                                                                        break;
                                                                    case 3:
                                                                        if (tvActivity.f3657c0 == null) {
                                                                            vc.a aVar = (vc.a) new a7.b(tvActivity).t(vc.a.class, "sports");
                                                                            aVar.f13485e = true;
                                                                            aVar.f13484d = new t(tvActivity, 2);
                                                                            tvActivity.f3657c0 = nc.h.U("sports");
                                                                            n0 n0VarO2 = tvActivity.o();
                                                                            androidx.fragment.app.a aVarI2 = e6.j.i(n0VarO2, n0VarO2);
                                                                            aVarI2.e(gc.j.sports_fragment_container, tvActivity.f3657c0, null, 1);
                                                                            aVarI2.d(false);
                                                                        }
                                                                        tvActivity.f3674u0 = false;
                                                                        tvActivity.f3673t0 = false;
                                                                        tvActivity.f3669p0 = false;
                                                                        tvActivity.f3672s0 = true;
                                                                        ((FragmentContainerView) tvActivity.Y.f2547d).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Y.f2544a).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Y.f2545b).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Y.f2548e).setVisibility(8);
                                                                        tvActivity.f3667n0 = "Sports";
                                                                        ((TextView) tvActivity.X.f2551j).setText("Sports");
                                                                        if (!tvActivity.f3670q0 || tvActivity.f3671r0) {
                                                                            tvActivity.f3671r0 = false;
                                                                            tvActivity.f3670q0 = false;
                                                                            tvActivity.Z = tvActivity.f3657c0;
                                                                            ((FragmentContainerView) tvActivity.Y.f2551j).setVisibility(0);
                                                                            ((FragmentContainerView) tvActivity.Y.i).setVisibility(8);
                                                                        } else {
                                                                            tvActivity.f3671r0 = true;
                                                                            nc.m mVar2 = tvActivity.f3659e0;
                                                                            tvActivity.Z = mVar2;
                                                                            tvActivity.V.B = mVar2.f8946v0;
                                                                            ((TextView) tvActivity.X.f2551j).setText(tvActivity.f3666m0);
                                                                            ((FragmentContainerView) tvActivity.Y.f2551j).setVisibility(8);
                                                                            ((FragmentContainerView) tvActivity.Y.i).setVisibility(0);
                                                                        }
                                                                        if (tvActivity.f3675v0 == 0) {
                                                                            tvActivity.f3656b0.S("");
                                                                        }
                                                                        break;
                                                                    case b1.j.LONG_FIELD_NUMBER /* 4 */:
                                                                        ((ImageView) tvActivity.X.f2549g).setVisibility(0);
                                                                        ((EditText) tvActivity.X.f2550h).setVisibility(0);
                                                                        ((EditText) tvActivity.X.f2550h).setFocusable(true);
                                                                        ((EditText) tvActivity.X.f2550h).requestFocus();
                                                                        ((InputMethodManager) tvActivity.getSystemService("input_method")).showSoftInput((EditText) tvActivity.X.f2550h, 1);
                                                                        break;
                                                                    case b1.j.STRING_FIELD_NUMBER /* 5 */:
                                                                        int i14 = TvActivity.f3654x0;
                                                                        tvActivity.f3660f0 = new nc.p();
                                                                        n0 n0VarO3 = tvActivity.o();
                                                                        androidx.fragment.app.a aVarI3 = e6.j.i(n0VarO3, n0VarO3);
                                                                        aVarI3.e(gc.j.fav_fragment_container, tvActivity.f3660f0, null, 1);
                                                                        aVarI3.d(false);
                                                                        tvActivity.f3674u0 = true;
                                                                        ((FragmentContainerView) tvActivity.Y.f2548e).setVisibility(0);
                                                                        if (tvActivity.f3662h0 != null) {
                                                                            tvActivity.x();
                                                                        }
                                                                        if (tvActivity.f3663i0 != null) {
                                                                            tvActivity.y();
                                                                        }
                                                                        ((TextView) tvActivity.X.f2551j).setText("Favourites");
                                                                        break;
                                                                    default:
                                                                        nc.f fVar = tvActivity.Z;
                                                                        if (fVar != null) {
                                                                            fVar.R();
                                                                        }
                                                                        break;
                                                                }
                                                            }
                                                        });
                                                        final int i14 = 3;
                                                        ((MaterialButton) this.X.i).setOnClickListener(new View.OnClickListener(this) { // from class: hc.s

                                                            /* JADX INFO: renamed from: v, reason: collision with root package name */
                                                            public final /* synthetic */ TvActivity f6061v;

                                                            {
                                                                this.f6061v = this;
                                                            }

                                                            @Override // android.view.View.OnClickListener
                                                            public final void onClick(View view) {
                                                                int i122 = i14;
                                                                TvActivity tvActivity = this.f6061v;
                                                                switch (i122) {
                                                                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                                                        ((DrawerLayout) tvActivity.W.f12869w).r();
                                                                        break;
                                                                    case 1:
                                                                        int i132 = TvActivity.f3654x0;
                                                                        tvActivity.z();
                                                                        break;
                                                                    case 2:
                                                                        if (tvActivity.f3656b0 == null) {
                                                                            ((vc.a) new a7.b(tvActivity).t(vc.a.class, "categories")).f13484d = new t(tvActivity, 4);
                                                                            tvActivity.f3656b0 = nc.h.U("categories");
                                                                            n0 n0VarO = tvActivity.o();
                                                                            androidx.fragment.app.a aVarI = e6.j.i(n0VarO, n0VarO);
                                                                            aVarI.e(gc.j.categories_fragment_container, tvActivity.f3656b0, null, 1);
                                                                            aVarI.d(false);
                                                                        }
                                                                        tvActivity.f3674u0 = false;
                                                                        tvActivity.f3673t0 = false;
                                                                        tvActivity.f3672s0 = false;
                                                                        ((FragmentContainerView) tvActivity.Y.f2547d).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Y.f2551j).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Y.i).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Y.f2548e).setVisibility(8);
                                                                        tvActivity.f3667n0 = "Categories";
                                                                        ((TextView) tvActivity.X.f2551j).setText("Categories");
                                                                        if (!tvActivity.f3668o0 || tvActivity.f3669p0) {
                                                                            tvActivity.f3669p0 = false;
                                                                            tvActivity.f3668o0 = false;
                                                                            tvActivity.Z = tvActivity.f3656b0;
                                                                            ((FragmentContainerView) tvActivity.Y.f2544a).setVisibility(0);
                                                                            ((FragmentContainerView) tvActivity.Y.f2545b).setVisibility(8);
                                                                        } else {
                                                                            tvActivity.f3669p0 = true;
                                                                            nc.m mVar = tvActivity.f3658d0;
                                                                            tvActivity.Z = mVar;
                                                                            tvActivity.V.B = mVar.f8946v0;
                                                                            ((TextView) tvActivity.X.f2551j).setText(tvActivity.l0);
                                                                            ((FragmentContainerView) tvActivity.Y.f2544a).setVisibility(8);
                                                                            ((FragmentContainerView) tvActivity.Y.f2545b).setVisibility(0);
                                                                        }
                                                                        if (tvActivity.f3675v0 == 0) {
                                                                            tvActivity.f3656b0.S("");
                                                                        }
                                                                        break;
                                                                    case 3:
                                                                        if (tvActivity.f3657c0 == null) {
                                                                            vc.a aVar = (vc.a) new a7.b(tvActivity).t(vc.a.class, "sports");
                                                                            aVar.f13485e = true;
                                                                            aVar.f13484d = new t(tvActivity, 2);
                                                                            tvActivity.f3657c0 = nc.h.U("sports");
                                                                            n0 n0VarO2 = tvActivity.o();
                                                                            androidx.fragment.app.a aVarI2 = e6.j.i(n0VarO2, n0VarO2);
                                                                            aVarI2.e(gc.j.sports_fragment_container, tvActivity.f3657c0, null, 1);
                                                                            aVarI2.d(false);
                                                                        }
                                                                        tvActivity.f3674u0 = false;
                                                                        tvActivity.f3673t0 = false;
                                                                        tvActivity.f3669p0 = false;
                                                                        tvActivity.f3672s0 = true;
                                                                        ((FragmentContainerView) tvActivity.Y.f2547d).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Y.f2544a).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Y.f2545b).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Y.f2548e).setVisibility(8);
                                                                        tvActivity.f3667n0 = "Sports";
                                                                        ((TextView) tvActivity.X.f2551j).setText("Sports");
                                                                        if (!tvActivity.f3670q0 || tvActivity.f3671r0) {
                                                                            tvActivity.f3671r0 = false;
                                                                            tvActivity.f3670q0 = false;
                                                                            tvActivity.Z = tvActivity.f3657c0;
                                                                            ((FragmentContainerView) tvActivity.Y.f2551j).setVisibility(0);
                                                                            ((FragmentContainerView) tvActivity.Y.i).setVisibility(8);
                                                                        } else {
                                                                            tvActivity.f3671r0 = true;
                                                                            nc.m mVar2 = tvActivity.f3659e0;
                                                                            tvActivity.Z = mVar2;
                                                                            tvActivity.V.B = mVar2.f8946v0;
                                                                            ((TextView) tvActivity.X.f2551j).setText(tvActivity.f3666m0);
                                                                            ((FragmentContainerView) tvActivity.Y.f2551j).setVisibility(8);
                                                                            ((FragmentContainerView) tvActivity.Y.i).setVisibility(0);
                                                                        }
                                                                        if (tvActivity.f3675v0 == 0) {
                                                                            tvActivity.f3656b0.S("");
                                                                        }
                                                                        break;
                                                                    case b1.j.LONG_FIELD_NUMBER /* 4 */:
                                                                        ((ImageView) tvActivity.X.f2549g).setVisibility(0);
                                                                        ((EditText) tvActivity.X.f2550h).setVisibility(0);
                                                                        ((EditText) tvActivity.X.f2550h).setFocusable(true);
                                                                        ((EditText) tvActivity.X.f2550h).requestFocus();
                                                                        ((InputMethodManager) tvActivity.getSystemService("input_method")).showSoftInput((EditText) tvActivity.X.f2550h, 1);
                                                                        break;
                                                                    case b1.j.STRING_FIELD_NUMBER /* 5 */:
                                                                        int i142 = TvActivity.f3654x0;
                                                                        tvActivity.f3660f0 = new nc.p();
                                                                        n0 n0VarO3 = tvActivity.o();
                                                                        androidx.fragment.app.a aVarI3 = e6.j.i(n0VarO3, n0VarO3);
                                                                        aVarI3.e(gc.j.fav_fragment_container, tvActivity.f3660f0, null, 1);
                                                                        aVarI3.d(false);
                                                                        tvActivity.f3674u0 = true;
                                                                        ((FragmentContainerView) tvActivity.Y.f2548e).setVisibility(0);
                                                                        if (tvActivity.f3662h0 != null) {
                                                                            tvActivity.x();
                                                                        }
                                                                        if (tvActivity.f3663i0 != null) {
                                                                            tvActivity.y();
                                                                        }
                                                                        ((TextView) tvActivity.X.f2551j).setText("Favourites");
                                                                        break;
                                                                    default:
                                                                        nc.f fVar = tvActivity.Z;
                                                                        if (fVar != null) {
                                                                            fVar.R();
                                                                        }
                                                                        break;
                                                                }
                                                            }
                                                        });
                                                        final int i15 = 4;
                                                        ((ImageButton) this.X.f).setOnClickListener(new View.OnClickListener(this) { // from class: hc.s

                                                            /* JADX INFO: renamed from: v, reason: collision with root package name */
                                                            public final /* synthetic */ TvActivity f6061v;

                                                            {
                                                                this.f6061v = this;
                                                            }

                                                            @Override // android.view.View.OnClickListener
                                                            public final void onClick(View view) {
                                                                int i122 = i15;
                                                                TvActivity tvActivity = this.f6061v;
                                                                switch (i122) {
                                                                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                                                        ((DrawerLayout) tvActivity.W.f12869w).r();
                                                                        break;
                                                                    case 1:
                                                                        int i132 = TvActivity.f3654x0;
                                                                        tvActivity.z();
                                                                        break;
                                                                    case 2:
                                                                        if (tvActivity.f3656b0 == null) {
                                                                            ((vc.a) new a7.b(tvActivity).t(vc.a.class, "categories")).f13484d = new t(tvActivity, 4);
                                                                            tvActivity.f3656b0 = nc.h.U("categories");
                                                                            n0 n0VarO = tvActivity.o();
                                                                            androidx.fragment.app.a aVarI = e6.j.i(n0VarO, n0VarO);
                                                                            aVarI.e(gc.j.categories_fragment_container, tvActivity.f3656b0, null, 1);
                                                                            aVarI.d(false);
                                                                        }
                                                                        tvActivity.f3674u0 = false;
                                                                        tvActivity.f3673t0 = false;
                                                                        tvActivity.f3672s0 = false;
                                                                        ((FragmentContainerView) tvActivity.Y.f2547d).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Y.f2551j).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Y.i).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Y.f2548e).setVisibility(8);
                                                                        tvActivity.f3667n0 = "Categories";
                                                                        ((TextView) tvActivity.X.f2551j).setText("Categories");
                                                                        if (!tvActivity.f3668o0 || tvActivity.f3669p0) {
                                                                            tvActivity.f3669p0 = false;
                                                                            tvActivity.f3668o0 = false;
                                                                            tvActivity.Z = tvActivity.f3656b0;
                                                                            ((FragmentContainerView) tvActivity.Y.f2544a).setVisibility(0);
                                                                            ((FragmentContainerView) tvActivity.Y.f2545b).setVisibility(8);
                                                                        } else {
                                                                            tvActivity.f3669p0 = true;
                                                                            nc.m mVar = tvActivity.f3658d0;
                                                                            tvActivity.Z = mVar;
                                                                            tvActivity.V.B = mVar.f8946v0;
                                                                            ((TextView) tvActivity.X.f2551j).setText(tvActivity.l0);
                                                                            ((FragmentContainerView) tvActivity.Y.f2544a).setVisibility(8);
                                                                            ((FragmentContainerView) tvActivity.Y.f2545b).setVisibility(0);
                                                                        }
                                                                        if (tvActivity.f3675v0 == 0) {
                                                                            tvActivity.f3656b0.S("");
                                                                        }
                                                                        break;
                                                                    case 3:
                                                                        if (tvActivity.f3657c0 == null) {
                                                                            vc.a aVar = (vc.a) new a7.b(tvActivity).t(vc.a.class, "sports");
                                                                            aVar.f13485e = true;
                                                                            aVar.f13484d = new t(tvActivity, 2);
                                                                            tvActivity.f3657c0 = nc.h.U("sports");
                                                                            n0 n0VarO2 = tvActivity.o();
                                                                            androidx.fragment.app.a aVarI2 = e6.j.i(n0VarO2, n0VarO2);
                                                                            aVarI2.e(gc.j.sports_fragment_container, tvActivity.f3657c0, null, 1);
                                                                            aVarI2.d(false);
                                                                        }
                                                                        tvActivity.f3674u0 = false;
                                                                        tvActivity.f3673t0 = false;
                                                                        tvActivity.f3669p0 = false;
                                                                        tvActivity.f3672s0 = true;
                                                                        ((FragmentContainerView) tvActivity.Y.f2547d).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Y.f2544a).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Y.f2545b).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Y.f2548e).setVisibility(8);
                                                                        tvActivity.f3667n0 = "Sports";
                                                                        ((TextView) tvActivity.X.f2551j).setText("Sports");
                                                                        if (!tvActivity.f3670q0 || tvActivity.f3671r0) {
                                                                            tvActivity.f3671r0 = false;
                                                                            tvActivity.f3670q0 = false;
                                                                            tvActivity.Z = tvActivity.f3657c0;
                                                                            ((FragmentContainerView) tvActivity.Y.f2551j).setVisibility(0);
                                                                            ((FragmentContainerView) tvActivity.Y.i).setVisibility(8);
                                                                        } else {
                                                                            tvActivity.f3671r0 = true;
                                                                            nc.m mVar2 = tvActivity.f3659e0;
                                                                            tvActivity.Z = mVar2;
                                                                            tvActivity.V.B = mVar2.f8946v0;
                                                                            ((TextView) tvActivity.X.f2551j).setText(tvActivity.f3666m0);
                                                                            ((FragmentContainerView) tvActivity.Y.f2551j).setVisibility(8);
                                                                            ((FragmentContainerView) tvActivity.Y.i).setVisibility(0);
                                                                        }
                                                                        if (tvActivity.f3675v0 == 0) {
                                                                            tvActivity.f3656b0.S("");
                                                                        }
                                                                        break;
                                                                    case b1.j.LONG_FIELD_NUMBER /* 4 */:
                                                                        ((ImageView) tvActivity.X.f2549g).setVisibility(0);
                                                                        ((EditText) tvActivity.X.f2550h).setVisibility(0);
                                                                        ((EditText) tvActivity.X.f2550h).setFocusable(true);
                                                                        ((EditText) tvActivity.X.f2550h).requestFocus();
                                                                        ((InputMethodManager) tvActivity.getSystemService("input_method")).showSoftInput((EditText) tvActivity.X.f2550h, 1);
                                                                        break;
                                                                    case b1.j.STRING_FIELD_NUMBER /* 5 */:
                                                                        int i142 = TvActivity.f3654x0;
                                                                        tvActivity.f3660f0 = new nc.p();
                                                                        n0 n0VarO3 = tvActivity.o();
                                                                        androidx.fragment.app.a aVarI3 = e6.j.i(n0VarO3, n0VarO3);
                                                                        aVarI3.e(gc.j.fav_fragment_container, tvActivity.f3660f0, null, 1);
                                                                        aVarI3.d(false);
                                                                        tvActivity.f3674u0 = true;
                                                                        ((FragmentContainerView) tvActivity.Y.f2548e).setVisibility(0);
                                                                        if (tvActivity.f3662h0 != null) {
                                                                            tvActivity.x();
                                                                        }
                                                                        if (tvActivity.f3663i0 != null) {
                                                                            tvActivity.y();
                                                                        }
                                                                        ((TextView) tvActivity.X.f2551j).setText("Favourites");
                                                                        break;
                                                                    default:
                                                                        nc.f fVar = tvActivity.Z;
                                                                        if (fVar != null) {
                                                                            fVar.R();
                                                                        }
                                                                        break;
                                                                }
                                                            }
                                                        });
                                                        final int i16 = 5;
                                                        ((ImageButton) this.X.f2546c).setOnClickListener(new View.OnClickListener(this) { // from class: hc.s

                                                            /* JADX INFO: renamed from: v, reason: collision with root package name */
                                                            public final /* synthetic */ TvActivity f6061v;

                                                            {
                                                                this.f6061v = this;
                                                            }

                                                            @Override // android.view.View.OnClickListener
                                                            public final void onClick(View view) {
                                                                int i122 = i16;
                                                                TvActivity tvActivity = this.f6061v;
                                                                switch (i122) {
                                                                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                                                        ((DrawerLayout) tvActivity.W.f12869w).r();
                                                                        break;
                                                                    case 1:
                                                                        int i132 = TvActivity.f3654x0;
                                                                        tvActivity.z();
                                                                        break;
                                                                    case 2:
                                                                        if (tvActivity.f3656b0 == null) {
                                                                            ((vc.a) new a7.b(tvActivity).t(vc.a.class, "categories")).f13484d = new t(tvActivity, 4);
                                                                            tvActivity.f3656b0 = nc.h.U("categories");
                                                                            n0 n0VarO = tvActivity.o();
                                                                            androidx.fragment.app.a aVarI = e6.j.i(n0VarO, n0VarO);
                                                                            aVarI.e(gc.j.categories_fragment_container, tvActivity.f3656b0, null, 1);
                                                                            aVarI.d(false);
                                                                        }
                                                                        tvActivity.f3674u0 = false;
                                                                        tvActivity.f3673t0 = false;
                                                                        tvActivity.f3672s0 = false;
                                                                        ((FragmentContainerView) tvActivity.Y.f2547d).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Y.f2551j).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Y.i).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Y.f2548e).setVisibility(8);
                                                                        tvActivity.f3667n0 = "Categories";
                                                                        ((TextView) tvActivity.X.f2551j).setText("Categories");
                                                                        if (!tvActivity.f3668o0 || tvActivity.f3669p0) {
                                                                            tvActivity.f3669p0 = false;
                                                                            tvActivity.f3668o0 = false;
                                                                            tvActivity.Z = tvActivity.f3656b0;
                                                                            ((FragmentContainerView) tvActivity.Y.f2544a).setVisibility(0);
                                                                            ((FragmentContainerView) tvActivity.Y.f2545b).setVisibility(8);
                                                                        } else {
                                                                            tvActivity.f3669p0 = true;
                                                                            nc.m mVar = tvActivity.f3658d0;
                                                                            tvActivity.Z = mVar;
                                                                            tvActivity.V.B = mVar.f8946v0;
                                                                            ((TextView) tvActivity.X.f2551j).setText(tvActivity.l0);
                                                                            ((FragmentContainerView) tvActivity.Y.f2544a).setVisibility(8);
                                                                            ((FragmentContainerView) tvActivity.Y.f2545b).setVisibility(0);
                                                                        }
                                                                        if (tvActivity.f3675v0 == 0) {
                                                                            tvActivity.f3656b0.S("");
                                                                        }
                                                                        break;
                                                                    case 3:
                                                                        if (tvActivity.f3657c0 == null) {
                                                                            vc.a aVar = (vc.a) new a7.b(tvActivity).t(vc.a.class, "sports");
                                                                            aVar.f13485e = true;
                                                                            aVar.f13484d = new t(tvActivity, 2);
                                                                            tvActivity.f3657c0 = nc.h.U("sports");
                                                                            n0 n0VarO2 = tvActivity.o();
                                                                            androidx.fragment.app.a aVarI2 = e6.j.i(n0VarO2, n0VarO2);
                                                                            aVarI2.e(gc.j.sports_fragment_container, tvActivity.f3657c0, null, 1);
                                                                            aVarI2.d(false);
                                                                        }
                                                                        tvActivity.f3674u0 = false;
                                                                        tvActivity.f3673t0 = false;
                                                                        tvActivity.f3669p0 = false;
                                                                        tvActivity.f3672s0 = true;
                                                                        ((FragmentContainerView) tvActivity.Y.f2547d).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Y.f2544a).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Y.f2545b).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Y.f2548e).setVisibility(8);
                                                                        tvActivity.f3667n0 = "Sports";
                                                                        ((TextView) tvActivity.X.f2551j).setText("Sports");
                                                                        if (!tvActivity.f3670q0 || tvActivity.f3671r0) {
                                                                            tvActivity.f3671r0 = false;
                                                                            tvActivity.f3670q0 = false;
                                                                            tvActivity.Z = tvActivity.f3657c0;
                                                                            ((FragmentContainerView) tvActivity.Y.f2551j).setVisibility(0);
                                                                            ((FragmentContainerView) tvActivity.Y.i).setVisibility(8);
                                                                        } else {
                                                                            tvActivity.f3671r0 = true;
                                                                            nc.m mVar2 = tvActivity.f3659e0;
                                                                            tvActivity.Z = mVar2;
                                                                            tvActivity.V.B = mVar2.f8946v0;
                                                                            ((TextView) tvActivity.X.f2551j).setText(tvActivity.f3666m0);
                                                                            ((FragmentContainerView) tvActivity.Y.f2551j).setVisibility(8);
                                                                            ((FragmentContainerView) tvActivity.Y.i).setVisibility(0);
                                                                        }
                                                                        if (tvActivity.f3675v0 == 0) {
                                                                            tvActivity.f3656b0.S("");
                                                                        }
                                                                        break;
                                                                    case b1.j.LONG_FIELD_NUMBER /* 4 */:
                                                                        ((ImageView) tvActivity.X.f2549g).setVisibility(0);
                                                                        ((EditText) tvActivity.X.f2550h).setVisibility(0);
                                                                        ((EditText) tvActivity.X.f2550h).setFocusable(true);
                                                                        ((EditText) tvActivity.X.f2550h).requestFocus();
                                                                        ((InputMethodManager) tvActivity.getSystemService("input_method")).showSoftInput((EditText) tvActivity.X.f2550h, 1);
                                                                        break;
                                                                    case b1.j.STRING_FIELD_NUMBER /* 5 */:
                                                                        int i142 = TvActivity.f3654x0;
                                                                        tvActivity.f3660f0 = new nc.p();
                                                                        n0 n0VarO3 = tvActivity.o();
                                                                        androidx.fragment.app.a aVarI3 = e6.j.i(n0VarO3, n0VarO3);
                                                                        aVarI3.e(gc.j.fav_fragment_container, tvActivity.f3660f0, null, 1);
                                                                        aVarI3.d(false);
                                                                        tvActivity.f3674u0 = true;
                                                                        ((FragmentContainerView) tvActivity.Y.f2548e).setVisibility(0);
                                                                        if (tvActivity.f3662h0 != null) {
                                                                            tvActivity.x();
                                                                        }
                                                                        if (tvActivity.f3663i0 != null) {
                                                                            tvActivity.y();
                                                                        }
                                                                        ((TextView) tvActivity.X.f2551j).setText("Favourites");
                                                                        break;
                                                                    default:
                                                                        nc.f fVar = tvActivity.Z;
                                                                        if (fVar != null) {
                                                                            fVar.R();
                                                                        }
                                                                        break;
                                                                }
                                                            }
                                                        });
                                                        final int i17 = 6;
                                                        ((ImageButton) this.X.f2548e).setOnClickListener(new View.OnClickListener(this) { // from class: hc.s

                                                            /* JADX INFO: renamed from: v, reason: collision with root package name */
                                                            public final /* synthetic */ TvActivity f6061v;

                                                            {
                                                                this.f6061v = this;
                                                            }

                                                            @Override // android.view.View.OnClickListener
                                                            public final void onClick(View view) {
                                                                int i122 = i17;
                                                                TvActivity tvActivity = this.f6061v;
                                                                switch (i122) {
                                                                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                                                        ((DrawerLayout) tvActivity.W.f12869w).r();
                                                                        break;
                                                                    case 1:
                                                                        int i132 = TvActivity.f3654x0;
                                                                        tvActivity.z();
                                                                        break;
                                                                    case 2:
                                                                        if (tvActivity.f3656b0 == null) {
                                                                            ((vc.a) new a7.b(tvActivity).t(vc.a.class, "categories")).f13484d = new t(tvActivity, 4);
                                                                            tvActivity.f3656b0 = nc.h.U("categories");
                                                                            n0 n0VarO = tvActivity.o();
                                                                            androidx.fragment.app.a aVarI = e6.j.i(n0VarO, n0VarO);
                                                                            aVarI.e(gc.j.categories_fragment_container, tvActivity.f3656b0, null, 1);
                                                                            aVarI.d(false);
                                                                        }
                                                                        tvActivity.f3674u0 = false;
                                                                        tvActivity.f3673t0 = false;
                                                                        tvActivity.f3672s0 = false;
                                                                        ((FragmentContainerView) tvActivity.Y.f2547d).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Y.f2551j).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Y.i).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Y.f2548e).setVisibility(8);
                                                                        tvActivity.f3667n0 = "Categories";
                                                                        ((TextView) tvActivity.X.f2551j).setText("Categories");
                                                                        if (!tvActivity.f3668o0 || tvActivity.f3669p0) {
                                                                            tvActivity.f3669p0 = false;
                                                                            tvActivity.f3668o0 = false;
                                                                            tvActivity.Z = tvActivity.f3656b0;
                                                                            ((FragmentContainerView) tvActivity.Y.f2544a).setVisibility(0);
                                                                            ((FragmentContainerView) tvActivity.Y.f2545b).setVisibility(8);
                                                                        } else {
                                                                            tvActivity.f3669p0 = true;
                                                                            nc.m mVar = tvActivity.f3658d0;
                                                                            tvActivity.Z = mVar;
                                                                            tvActivity.V.B = mVar.f8946v0;
                                                                            ((TextView) tvActivity.X.f2551j).setText(tvActivity.l0);
                                                                            ((FragmentContainerView) tvActivity.Y.f2544a).setVisibility(8);
                                                                            ((FragmentContainerView) tvActivity.Y.f2545b).setVisibility(0);
                                                                        }
                                                                        if (tvActivity.f3675v0 == 0) {
                                                                            tvActivity.f3656b0.S("");
                                                                        }
                                                                        break;
                                                                    case 3:
                                                                        if (tvActivity.f3657c0 == null) {
                                                                            vc.a aVar = (vc.a) new a7.b(tvActivity).t(vc.a.class, "sports");
                                                                            aVar.f13485e = true;
                                                                            aVar.f13484d = new t(tvActivity, 2);
                                                                            tvActivity.f3657c0 = nc.h.U("sports");
                                                                            n0 n0VarO2 = tvActivity.o();
                                                                            androidx.fragment.app.a aVarI2 = e6.j.i(n0VarO2, n0VarO2);
                                                                            aVarI2.e(gc.j.sports_fragment_container, tvActivity.f3657c0, null, 1);
                                                                            aVarI2.d(false);
                                                                        }
                                                                        tvActivity.f3674u0 = false;
                                                                        tvActivity.f3673t0 = false;
                                                                        tvActivity.f3669p0 = false;
                                                                        tvActivity.f3672s0 = true;
                                                                        ((FragmentContainerView) tvActivity.Y.f2547d).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Y.f2544a).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Y.f2545b).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Y.f2548e).setVisibility(8);
                                                                        tvActivity.f3667n0 = "Sports";
                                                                        ((TextView) tvActivity.X.f2551j).setText("Sports");
                                                                        if (!tvActivity.f3670q0 || tvActivity.f3671r0) {
                                                                            tvActivity.f3671r0 = false;
                                                                            tvActivity.f3670q0 = false;
                                                                            tvActivity.Z = tvActivity.f3657c0;
                                                                            ((FragmentContainerView) tvActivity.Y.f2551j).setVisibility(0);
                                                                            ((FragmentContainerView) tvActivity.Y.i).setVisibility(8);
                                                                        } else {
                                                                            tvActivity.f3671r0 = true;
                                                                            nc.m mVar2 = tvActivity.f3659e0;
                                                                            tvActivity.Z = mVar2;
                                                                            tvActivity.V.B = mVar2.f8946v0;
                                                                            ((TextView) tvActivity.X.f2551j).setText(tvActivity.f3666m0);
                                                                            ((FragmentContainerView) tvActivity.Y.f2551j).setVisibility(8);
                                                                            ((FragmentContainerView) tvActivity.Y.i).setVisibility(0);
                                                                        }
                                                                        if (tvActivity.f3675v0 == 0) {
                                                                            tvActivity.f3656b0.S("");
                                                                        }
                                                                        break;
                                                                    case b1.j.LONG_FIELD_NUMBER /* 4 */:
                                                                        ((ImageView) tvActivity.X.f2549g).setVisibility(0);
                                                                        ((EditText) tvActivity.X.f2550h).setVisibility(0);
                                                                        ((EditText) tvActivity.X.f2550h).setFocusable(true);
                                                                        ((EditText) tvActivity.X.f2550h).requestFocus();
                                                                        ((InputMethodManager) tvActivity.getSystemService("input_method")).showSoftInput((EditText) tvActivity.X.f2550h, 1);
                                                                        break;
                                                                    case b1.j.STRING_FIELD_NUMBER /* 5 */:
                                                                        int i142 = TvActivity.f3654x0;
                                                                        tvActivity.f3660f0 = new nc.p();
                                                                        n0 n0VarO3 = tvActivity.o();
                                                                        androidx.fragment.app.a aVarI3 = e6.j.i(n0VarO3, n0VarO3);
                                                                        aVarI3.e(gc.j.fav_fragment_container, tvActivity.f3660f0, null, 1);
                                                                        aVarI3.d(false);
                                                                        tvActivity.f3674u0 = true;
                                                                        ((FragmentContainerView) tvActivity.Y.f2548e).setVisibility(0);
                                                                        if (tvActivity.f3662h0 != null) {
                                                                            tvActivity.x();
                                                                        }
                                                                        if (tvActivity.f3663i0 != null) {
                                                                            tvActivity.y();
                                                                        }
                                                                        ((TextView) tvActivity.X.f2551j).setText("Favourites");
                                                                        break;
                                                                    default:
                                                                        nc.f fVar = tvActivity.Z;
                                                                        if (fVar != null) {
                                                                            fVar.R();
                                                                        }
                                                                        break;
                                                                }
                                                            }
                                                        });
                                                        ((NavigationView) this.W.f12870x).setNavigationItemSelectedListener(new t(this, 0));
                                                        z();
                                                        try {
                                                            ((TextView) ((NavigationView) this.W.f12870x).C.f6902v.getChildAt(0).findViewById(gc.j.app_version_txt)).setText("Version: " + getPackageManager().getPackageInfo(getPackageName(), 0).versionName);
                                                        } catch (PackageManager.NameNotFoundException e10) {
                                                            e10.printStackTrace();
                                                        }
                                                        ((EditText) this.X.f2550h).addTextChangedListener(new v(0, this));
                                                        ((EditText) this.X.f2550h).setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: hc.u
                                                            @Override // android.widget.TextView.OnEditorActionListener
                                                            public final boolean onEditorAction(TextView textView2, int i18, KeyEvent keyEvent) {
                                                                int i19 = TvActivity.f3654x0;
                                                                if (i18 != 6) {
                                                                    return false;
                                                                }
                                                                TvActivity tvActivity = this.f6064a;
                                                                ((InputMethodManager) tvActivity.getSystemService("input_method")).hideSoftInputFromWindow(((EditText) tvActivity.X.f2550h).getWindowToken(), 0);
                                                                return true;
                                                            }
                                                        });
                                                        String str = this.f3664j0.E;
                                                        if (str != null && str.trim().startsWith("http")) {
                                                            this.f3661g0 = new e(str, this.f3664j0.F, new t(this, 1));
                                                            n0 n0VarO = o();
                                                            androidx.fragment.app.a aVarI = e6.j.i(n0VarO, n0VarO);
                                                            aVarI.f1226b = R.anim.fade_in;
                                                            aVarI.f1227c = R.anim.fade_out;
                                                            aVarI.f1228d = 0;
                                                            aVarI.f1229e = 0;
                                                            aVarI.e(R.id.content, this.f3661g0, null, 1);
                                                            if (!aVarI.f1231h) {
                                                                throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
                                                            }
                                                            aVarI.f1230g = true;
                                                            aVarI.i = null;
                                                            aVarI.d(false);
                                                        }
                                                        this.V.f3680x = new t(this, 3);
                                                        File externalFilesDir = getExternalFilesDir(null);
                                                        if (externalFilesDir == null) {
                                                            return;
                                                        }
                                                        a1.B(externalFilesDir);
                                                        return;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                throw new NullPointerException("Missing required view with ID: ".concat(viewK.getResources().getResourceName(i10)));
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    public final void w() {
        View currentFocus = getCurrentFocus();
        if (currentFocus != null) {
            currentFocus.clearFocus();
        }
    }

    public final void x() {
        ((FragmentContainerView) this.Y.f).setVisibility(8);
        n0 n0VarO = o();
        n0VarO.getClass();
        androidx.fragment.app.a aVar = new androidx.fragment.app.a(n0VarO);
        aVar.g(this.f3662h0);
        aVar.d(false);
        this.f3662h0 = null;
    }

    public final void y() {
        ((FragmentContainerView) this.Y.f2549g).setVisibility(8);
        n0 n0VarO = o();
        n0VarO.getClass();
        androidx.fragment.app.a aVar = new androidx.fragment.app.a(n0VarO);
        aVar.g(this.f3663i0);
        aVar.d(false);
        this.f3663i0 = null;
    }

    public final void z() {
        if (this.f3655a0 == null) {
            b bVar = (b) new a7.b(this).s(b.class);
            a aVar = this.f3664j0;
            bVar.f13487e = aVar.f9509y;
            bVar.f = aVar.f9510z;
            bVar.f13488g = aVar.C;
            bVar.f13489h = aVar.D;
            this.f3655a0 = new nc.o();
            n0 n0VarO = o();
            androidx.fragment.app.a aVarI = e6.j.i(n0VarO, n0VarO);
            aVarI.e(gc.j.events_fragment_container, this.f3655a0, null, 1);
            aVarI.d(false);
        }
        this.f3673t0 = true;
        this.f3674u0 = false;
        this.f3672s0 = false;
        this.f3669p0 = false;
        this.f3671r0 = false;
        this.Z = this.f3655a0;
        ((FragmentContainerView) this.Y.f2547d).setVisibility(0);
        ((FragmentContainerView) this.Y.f2551j).setVisibility(8);
        ((FragmentContainerView) this.Y.i).setVisibility(8);
        ((FragmentContainerView) this.Y.f2544a).setVisibility(8);
        ((FragmentContainerView) this.Y.f2545b).setVisibility(8);
        ((FragmentContainerView) this.Y.f2548e).setVisibility(8);
        String str = this.f3665k0;
        this.f3667n0 = str;
        ((TextView) this.X.f2551j).setText(str);
    }
}
