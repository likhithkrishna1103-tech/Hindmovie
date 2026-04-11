package app.cricfy.tv.activities;

import android.R;
import android.content.Intent;
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
import androidx.emoji2.text.v;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.i0;
import androidx.fragment.app.r0;
import androidx.media3.decoder.DecoderInputBuffer;
import app.cricfy.tv.activities.TvActivity;
import app.cricfy.tv.app.ProApplication;
import b6.f;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.navigation.NavigationView;
import h.j;
import h.p;
import hd.e;
import java.io.File;
import o.s2;
import q5.o;
import r5.q;
import u5.a;
import x5.b;
import x5.c;
import x5.i;
import x5.k;
import x5.l;
import x5.r;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class TvActivity extends j {

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public static final /* synthetic */ int f1550s0 = 0;
    public ProApplication W;
    public f X;
    public a Y;
    public e Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public c f1551a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public k f1552b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public x5.e f1553c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public i f1554d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public i f1555e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public l f1556f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public b f1557g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public r f1558h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public y5.a f1559i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public String f1560j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public String f1561k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public String f1562l0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public boolean f1565p0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public boolean f1563m0 = false;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public boolean f1564n0 = false;
    public boolean o0 = true;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public int f1566q0 = -1;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public final i0 f1567r0 = new i0(this, 4);

    @Override // h.j, c.m, h0.e, android.app.Activity
    public final void onCreate(Bundle bundle) {
        View viewL;
        String str;
        p.k();
        super.onCreate(bundle);
        View viewInflate = getLayoutInflater().inflate(q5.l.activity_tv, (ViewGroup) null, false);
        int i = q5.k.content_binding;
        View viewL2 = android.support.v4.media.session.b.l(viewInflate, i);
        if (viewL2 != null) {
            e eVarA = e.a(viewL2);
            DrawerLayout drawerLayout = (DrawerLayout) viewInflate;
            i = q5.k.navigationView;
            NavigationView navigationView = (NavigationView) android.support.v4.media.session.b.l(viewInflate, i);
            if (navigationView != null && (viewL = android.support.v4.media.session.b.l(viewInflate, (i = q5.k.top_binding))) != null) {
                int i10 = q5.k.cats_btn;
                MaterialButton materialButton = (MaterialButton) android.support.v4.media.session.b.l(viewL, i10);
                if (materialButton != null) {
                    i10 = q5.k.events_btn;
                    MaterialButton materialButton2 = (MaterialButton) android.support.v4.media.session.b.l(viewL, i10);
                    if (materialButton2 != null) {
                        i10 = q5.k.fav_btn;
                        MaterialButton materialButton3 = (MaterialButton) android.support.v4.media.session.b.l(viewL, i10);
                        if (materialButton3 != null) {
                            i10 = q5.k.menu_btn;
                            ImageButton imageButton = (ImageButton) android.support.v4.media.session.b.l(viewL, i10);
                            if (imageButton != null) {
                                i10 = q5.k.refresh_btn;
                                ImageButton imageButton2 = (ImageButton) android.support.v4.media.session.b.l(viewL, i10);
                                if (imageButton2 != null) {
                                    i10 = q5.k.search_btn;
                                    ImageButton imageButton3 = (ImageButton) android.support.v4.media.session.b.l(viewL, i10);
                                    if (imageButton3 != null) {
                                        i10 = q5.k.search_img;
                                        ImageView imageView = (ImageView) android.support.v4.media.session.b.l(viewL, i10);
                                        if (imageView != null) {
                                            i10 = q5.k.search_view;
                                            EditText editText = (EditText) android.support.v4.media.session.b.l(viewL, i10);
                                            if (editText != null) {
                                                i10 = q5.k.sports_btn;
                                                MaterialButton materialButton4 = (MaterialButton) android.support.v4.media.session.b.l(viewL, i10);
                                                if (materialButton4 != null) {
                                                    int i11 = q5.k.title_txt;
                                                    TextView textView = (TextView) android.support.v4.media.session.b.l(viewL, i11);
                                                    if (textView != null) {
                                                        a aVar = new a();
                                                        aVar.f12213b = materialButton;
                                                        aVar.f12214c = materialButton2;
                                                        aVar.f12215d = materialButton3;
                                                        aVar.f12216e = imageButton;
                                                        aVar.f = imageButton2;
                                                        aVar.f12217g = imageButton3;
                                                        aVar.f12218h = imageView;
                                                        aVar.i = editText;
                                                        aVar.f12219j = materialButton4;
                                                        aVar.f12212a = textView;
                                                        this.X = new f(drawerLayout, eVarA, drawerLayout, navigationView, aVar, 13);
                                                        setContentView(drawerLayout);
                                                        f fVar = this.X;
                                                        this.Y = (a) fVar.f1803z;
                                                        this.Z = (e) fVar.f1800w;
                                                        j().a(this.f1567r0, this);
                                                        ProApplication proApplication = ProApplication.K;
                                                        this.W = proApplication;
                                                        proApplication.f1568v = this;
                                                        this.f1560j0 = getString(o.app_name);
                                                        Intent intent = getIntent();
                                                        if (Build.VERSION.SDK_INT > 33) {
                                                            this.f1559i0 = (y5.a) intent.getParcelableExtra("appDetail", y5.a.class);
                                                        } else {
                                                            this.f1559i0 = (y5.a) intent.getParcelableExtra("appDetail");
                                                        }
                                                        View currentFocus = getCurrentFocus();
                                                        if (currentFocus != null) {
                                                            currentFocus.clearFocus();
                                                        }
                                                        ((MaterialButton) this.Y.f12214c).requestFocus();
                                                        final int i12 = 0;
                                                        ((ImageButton) this.Y.f12216e).setOnClickListener(new View.OnClickListener(this) { // from class: r5.p

                                                            /* JADX INFO: renamed from: w, reason: collision with root package name */
                                                            public final /* synthetic */ TvActivity f10882w;

                                                            {
                                                                this.f10882w = this;
                                                            }

                                                            @Override // android.view.View.OnClickListener
                                                            public final void onClick(View view) {
                                                                int i13 = i12;
                                                                TvActivity tvActivity = this.f10882w;
                                                                switch (i13) {
                                                                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                                                        ((DrawerLayout) tvActivity.X.f1801x).r();
                                                                        break;
                                                                    case 1:
                                                                        int i14 = TvActivity.f1550s0;
                                                                        tvActivity.x();
                                                                        break;
                                                                    case 2:
                                                                        if (tvActivity.f1553c0 == null) {
                                                                            ((f6.a) new v(tvActivity).s(f6.a.class, "categories")).f3975d = new q(tvActivity);
                                                                            x5.e eVar = new x5.e();
                                                                            Bundle bundle2 = new Bundle();
                                                                            bundle2.putString("tag", "categories");
                                                                            eVar.N(bundle2);
                                                                            tvActivity.f1553c0 = eVar;
                                                                            r0 r0VarO = tvActivity.o();
                                                                            androidx.fragment.app.a aVarF = l0.e.f(r0VarO, r0VarO);
                                                                            aVarF.f(q5.k.categories_fragment_container, tvActivity.f1553c0, null, 1);
                                                                            aVarF.e(false);
                                                                        }
                                                                        tvActivity.f1565p0 = false;
                                                                        tvActivity.o0 = false;
                                                                        ((FragmentContainerView) tvActivity.Z.f5927c).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Z.f5931h).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Z.f5930g).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Z.f5928d).setVisibility(8);
                                                                        tvActivity.f1562l0 = "Categories";
                                                                        ((TextView) tvActivity.Y.f12212a).setText("Categories");
                                                                        if (!tvActivity.f1563m0 || tvActivity.f1564n0) {
                                                                            tvActivity.f1564n0 = false;
                                                                            tvActivity.f1563m0 = false;
                                                                            tvActivity.f1551a0 = tvActivity.f1553c0;
                                                                            ((FragmentContainerView) tvActivity.Z.f5925a).setVisibility(0);
                                                                            ((FragmentContainerView) tvActivity.Z.f5926b).setVisibility(8);
                                                                        } else {
                                                                            tvActivity.f1564n0 = true;
                                                                            x5.i iVar = tvActivity.f1554d0;
                                                                            tvActivity.f1551a0 = iVar;
                                                                            tvActivity.W.C = iVar.f14350w0;
                                                                            ((TextView) tvActivity.Y.f12212a).setText(tvActivity.f1561k0);
                                                                            ((FragmentContainerView) tvActivity.Z.f5925a).setVisibility(8);
                                                                            ((FragmentContainerView) tvActivity.Z.f5926b).setVisibility(0);
                                                                        }
                                                                        if (tvActivity.f1566q0 == 0) {
                                                                            tvActivity.f1553c0.U("");
                                                                        }
                                                                        break;
                                                                    case 3:
                                                                        if (tvActivity.f1555e0 == null) {
                                                                            y5.a aVar2 = tvActivity.f1559i0;
                                                                            tvActivity.f1555e0 = x5.i.X(aVar2.f14904v, aVar2.f14905w, true);
                                                                            r0 r0VarO2 = tvActivity.o();
                                                                            androidx.fragment.app.a aVarF2 = l0.e.f(r0VarO2, r0VarO2);
                                                                            aVarF2.f(q5.k.sports_fragment_container, tvActivity.f1555e0, null, 1);
                                                                            aVarF2.e(false);
                                                                        }
                                                                        tvActivity.f1565p0 = false;
                                                                        tvActivity.o0 = false;
                                                                        tvActivity.f1564n0 = false;
                                                                        ((FragmentContainerView) tvActivity.Z.f5927c).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Z.f5925a).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Z.f5926b).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Z.f5928d).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Z.f5931h).setVisibility(0);
                                                                        tvActivity.f1551a0 = tvActivity.f1555e0;
                                                                        tvActivity.f1562l0 = "Sports";
                                                                        u5.a aVar3 = tvActivity.Y;
                                                                        if (aVar3 != null) {
                                                                            ((TextView) aVar3.f12212a).setText("Sports");
                                                                        }
                                                                        if (tvActivity.f1566q0 == 0) {
                                                                            tvActivity.f1553c0.U("");
                                                                        }
                                                                        break;
                                                                    case g1.h.LONG_FIELD_NUMBER /* 4 */:
                                                                        ((ImageView) tvActivity.Y.f12218h).setVisibility(0);
                                                                        ((EditText) tvActivity.Y.i).setVisibility(0);
                                                                        ((EditText) tvActivity.Y.i).setFocusable(true);
                                                                        ((EditText) tvActivity.Y.i).requestFocus();
                                                                        ((InputMethodManager) tvActivity.getSystemService("input_method")).showSoftInput((EditText) tvActivity.Y.i, 1);
                                                                        break;
                                                                    case g1.h.STRING_FIELD_NUMBER /* 5 */:
                                                                        int i15 = TvActivity.f1550s0;
                                                                        tvActivity.f1556f0 = new x5.l();
                                                                        r0 r0VarO3 = tvActivity.o();
                                                                        androidx.fragment.app.a aVarF3 = l0.e.f(r0VarO3, r0VarO3);
                                                                        aVarF3.f(q5.k.fav_fragment_container, tvActivity.f1556f0, null, 1);
                                                                        aVarF3.e(false);
                                                                        tvActivity.f1565p0 = true;
                                                                        ((FragmentContainerView) tvActivity.Z.f5928d).setVisibility(0);
                                                                        if (tvActivity.f1558h0 != null) {
                                                                            tvActivity.w();
                                                                        }
                                                                        ((TextView) tvActivity.Y.f12212a).setText("Favourites");
                                                                        break;
                                                                    default:
                                                                        x5.c cVar = tvActivity.f1551a0;
                                                                        if (cVar != null) {
                                                                            cVar.T();
                                                                        }
                                                                        break;
                                                                }
                                                            }
                                                        });
                                                        final int i13 = 1;
                                                        ((MaterialButton) this.Y.f12214c).setOnClickListener(new View.OnClickListener(this) { // from class: r5.p

                                                            /* JADX INFO: renamed from: w, reason: collision with root package name */
                                                            public final /* synthetic */ TvActivity f10882w;

                                                            {
                                                                this.f10882w = this;
                                                            }

                                                            @Override // android.view.View.OnClickListener
                                                            public final void onClick(View view) {
                                                                int i132 = i13;
                                                                TvActivity tvActivity = this.f10882w;
                                                                switch (i132) {
                                                                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                                                        ((DrawerLayout) tvActivity.X.f1801x).r();
                                                                        break;
                                                                    case 1:
                                                                        int i14 = TvActivity.f1550s0;
                                                                        tvActivity.x();
                                                                        break;
                                                                    case 2:
                                                                        if (tvActivity.f1553c0 == null) {
                                                                            ((f6.a) new v(tvActivity).s(f6.a.class, "categories")).f3975d = new q(tvActivity);
                                                                            x5.e eVar = new x5.e();
                                                                            Bundle bundle2 = new Bundle();
                                                                            bundle2.putString("tag", "categories");
                                                                            eVar.N(bundle2);
                                                                            tvActivity.f1553c0 = eVar;
                                                                            r0 r0VarO = tvActivity.o();
                                                                            androidx.fragment.app.a aVarF = l0.e.f(r0VarO, r0VarO);
                                                                            aVarF.f(q5.k.categories_fragment_container, tvActivity.f1553c0, null, 1);
                                                                            aVarF.e(false);
                                                                        }
                                                                        tvActivity.f1565p0 = false;
                                                                        tvActivity.o0 = false;
                                                                        ((FragmentContainerView) tvActivity.Z.f5927c).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Z.f5931h).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Z.f5930g).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Z.f5928d).setVisibility(8);
                                                                        tvActivity.f1562l0 = "Categories";
                                                                        ((TextView) tvActivity.Y.f12212a).setText("Categories");
                                                                        if (!tvActivity.f1563m0 || tvActivity.f1564n0) {
                                                                            tvActivity.f1564n0 = false;
                                                                            tvActivity.f1563m0 = false;
                                                                            tvActivity.f1551a0 = tvActivity.f1553c0;
                                                                            ((FragmentContainerView) tvActivity.Z.f5925a).setVisibility(0);
                                                                            ((FragmentContainerView) tvActivity.Z.f5926b).setVisibility(8);
                                                                        } else {
                                                                            tvActivity.f1564n0 = true;
                                                                            x5.i iVar = tvActivity.f1554d0;
                                                                            tvActivity.f1551a0 = iVar;
                                                                            tvActivity.W.C = iVar.f14350w0;
                                                                            ((TextView) tvActivity.Y.f12212a).setText(tvActivity.f1561k0);
                                                                            ((FragmentContainerView) tvActivity.Z.f5925a).setVisibility(8);
                                                                            ((FragmentContainerView) tvActivity.Z.f5926b).setVisibility(0);
                                                                        }
                                                                        if (tvActivity.f1566q0 == 0) {
                                                                            tvActivity.f1553c0.U("");
                                                                        }
                                                                        break;
                                                                    case 3:
                                                                        if (tvActivity.f1555e0 == null) {
                                                                            y5.a aVar2 = tvActivity.f1559i0;
                                                                            tvActivity.f1555e0 = x5.i.X(aVar2.f14904v, aVar2.f14905w, true);
                                                                            r0 r0VarO2 = tvActivity.o();
                                                                            androidx.fragment.app.a aVarF2 = l0.e.f(r0VarO2, r0VarO2);
                                                                            aVarF2.f(q5.k.sports_fragment_container, tvActivity.f1555e0, null, 1);
                                                                            aVarF2.e(false);
                                                                        }
                                                                        tvActivity.f1565p0 = false;
                                                                        tvActivity.o0 = false;
                                                                        tvActivity.f1564n0 = false;
                                                                        ((FragmentContainerView) tvActivity.Z.f5927c).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Z.f5925a).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Z.f5926b).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Z.f5928d).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Z.f5931h).setVisibility(0);
                                                                        tvActivity.f1551a0 = tvActivity.f1555e0;
                                                                        tvActivity.f1562l0 = "Sports";
                                                                        u5.a aVar3 = tvActivity.Y;
                                                                        if (aVar3 != null) {
                                                                            ((TextView) aVar3.f12212a).setText("Sports");
                                                                        }
                                                                        if (tvActivity.f1566q0 == 0) {
                                                                            tvActivity.f1553c0.U("");
                                                                        }
                                                                        break;
                                                                    case g1.h.LONG_FIELD_NUMBER /* 4 */:
                                                                        ((ImageView) tvActivity.Y.f12218h).setVisibility(0);
                                                                        ((EditText) tvActivity.Y.i).setVisibility(0);
                                                                        ((EditText) tvActivity.Y.i).setFocusable(true);
                                                                        ((EditText) tvActivity.Y.i).requestFocus();
                                                                        ((InputMethodManager) tvActivity.getSystemService("input_method")).showSoftInput((EditText) tvActivity.Y.i, 1);
                                                                        break;
                                                                    case g1.h.STRING_FIELD_NUMBER /* 5 */:
                                                                        int i15 = TvActivity.f1550s0;
                                                                        tvActivity.f1556f0 = new x5.l();
                                                                        r0 r0VarO3 = tvActivity.o();
                                                                        androidx.fragment.app.a aVarF3 = l0.e.f(r0VarO3, r0VarO3);
                                                                        aVarF3.f(q5.k.fav_fragment_container, tvActivity.f1556f0, null, 1);
                                                                        aVarF3.e(false);
                                                                        tvActivity.f1565p0 = true;
                                                                        ((FragmentContainerView) tvActivity.Z.f5928d).setVisibility(0);
                                                                        if (tvActivity.f1558h0 != null) {
                                                                            tvActivity.w();
                                                                        }
                                                                        ((TextView) tvActivity.Y.f12212a).setText("Favourites");
                                                                        break;
                                                                    default:
                                                                        x5.c cVar = tvActivity.f1551a0;
                                                                        if (cVar != null) {
                                                                            cVar.T();
                                                                        }
                                                                        break;
                                                                }
                                                            }
                                                        });
                                                        final int i14 = 2;
                                                        ((MaterialButton) this.Y.f12213b).setOnClickListener(new View.OnClickListener(this) { // from class: r5.p

                                                            /* JADX INFO: renamed from: w, reason: collision with root package name */
                                                            public final /* synthetic */ TvActivity f10882w;

                                                            {
                                                                this.f10882w = this;
                                                            }

                                                            @Override // android.view.View.OnClickListener
                                                            public final void onClick(View view) {
                                                                int i132 = i14;
                                                                TvActivity tvActivity = this.f10882w;
                                                                switch (i132) {
                                                                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                                                        ((DrawerLayout) tvActivity.X.f1801x).r();
                                                                        break;
                                                                    case 1:
                                                                        int i142 = TvActivity.f1550s0;
                                                                        tvActivity.x();
                                                                        break;
                                                                    case 2:
                                                                        if (tvActivity.f1553c0 == null) {
                                                                            ((f6.a) new v(tvActivity).s(f6.a.class, "categories")).f3975d = new q(tvActivity);
                                                                            x5.e eVar = new x5.e();
                                                                            Bundle bundle2 = new Bundle();
                                                                            bundle2.putString("tag", "categories");
                                                                            eVar.N(bundle2);
                                                                            tvActivity.f1553c0 = eVar;
                                                                            r0 r0VarO = tvActivity.o();
                                                                            androidx.fragment.app.a aVarF = l0.e.f(r0VarO, r0VarO);
                                                                            aVarF.f(q5.k.categories_fragment_container, tvActivity.f1553c0, null, 1);
                                                                            aVarF.e(false);
                                                                        }
                                                                        tvActivity.f1565p0 = false;
                                                                        tvActivity.o0 = false;
                                                                        ((FragmentContainerView) tvActivity.Z.f5927c).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Z.f5931h).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Z.f5930g).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Z.f5928d).setVisibility(8);
                                                                        tvActivity.f1562l0 = "Categories";
                                                                        ((TextView) tvActivity.Y.f12212a).setText("Categories");
                                                                        if (!tvActivity.f1563m0 || tvActivity.f1564n0) {
                                                                            tvActivity.f1564n0 = false;
                                                                            tvActivity.f1563m0 = false;
                                                                            tvActivity.f1551a0 = tvActivity.f1553c0;
                                                                            ((FragmentContainerView) tvActivity.Z.f5925a).setVisibility(0);
                                                                            ((FragmentContainerView) tvActivity.Z.f5926b).setVisibility(8);
                                                                        } else {
                                                                            tvActivity.f1564n0 = true;
                                                                            x5.i iVar = tvActivity.f1554d0;
                                                                            tvActivity.f1551a0 = iVar;
                                                                            tvActivity.W.C = iVar.f14350w0;
                                                                            ((TextView) tvActivity.Y.f12212a).setText(tvActivity.f1561k0);
                                                                            ((FragmentContainerView) tvActivity.Z.f5925a).setVisibility(8);
                                                                            ((FragmentContainerView) tvActivity.Z.f5926b).setVisibility(0);
                                                                        }
                                                                        if (tvActivity.f1566q0 == 0) {
                                                                            tvActivity.f1553c0.U("");
                                                                        }
                                                                        break;
                                                                    case 3:
                                                                        if (tvActivity.f1555e0 == null) {
                                                                            y5.a aVar2 = tvActivity.f1559i0;
                                                                            tvActivity.f1555e0 = x5.i.X(aVar2.f14904v, aVar2.f14905w, true);
                                                                            r0 r0VarO2 = tvActivity.o();
                                                                            androidx.fragment.app.a aVarF2 = l0.e.f(r0VarO2, r0VarO2);
                                                                            aVarF2.f(q5.k.sports_fragment_container, tvActivity.f1555e0, null, 1);
                                                                            aVarF2.e(false);
                                                                        }
                                                                        tvActivity.f1565p0 = false;
                                                                        tvActivity.o0 = false;
                                                                        tvActivity.f1564n0 = false;
                                                                        ((FragmentContainerView) tvActivity.Z.f5927c).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Z.f5925a).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Z.f5926b).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Z.f5928d).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Z.f5931h).setVisibility(0);
                                                                        tvActivity.f1551a0 = tvActivity.f1555e0;
                                                                        tvActivity.f1562l0 = "Sports";
                                                                        u5.a aVar3 = tvActivity.Y;
                                                                        if (aVar3 != null) {
                                                                            ((TextView) aVar3.f12212a).setText("Sports");
                                                                        }
                                                                        if (tvActivity.f1566q0 == 0) {
                                                                            tvActivity.f1553c0.U("");
                                                                        }
                                                                        break;
                                                                    case g1.h.LONG_FIELD_NUMBER /* 4 */:
                                                                        ((ImageView) tvActivity.Y.f12218h).setVisibility(0);
                                                                        ((EditText) tvActivity.Y.i).setVisibility(0);
                                                                        ((EditText) tvActivity.Y.i).setFocusable(true);
                                                                        ((EditText) tvActivity.Y.i).requestFocus();
                                                                        ((InputMethodManager) tvActivity.getSystemService("input_method")).showSoftInput((EditText) tvActivity.Y.i, 1);
                                                                        break;
                                                                    case g1.h.STRING_FIELD_NUMBER /* 5 */:
                                                                        int i15 = TvActivity.f1550s0;
                                                                        tvActivity.f1556f0 = new x5.l();
                                                                        r0 r0VarO3 = tvActivity.o();
                                                                        androidx.fragment.app.a aVarF3 = l0.e.f(r0VarO3, r0VarO3);
                                                                        aVarF3.f(q5.k.fav_fragment_container, tvActivity.f1556f0, null, 1);
                                                                        aVarF3.e(false);
                                                                        tvActivity.f1565p0 = true;
                                                                        ((FragmentContainerView) tvActivity.Z.f5928d).setVisibility(0);
                                                                        if (tvActivity.f1558h0 != null) {
                                                                            tvActivity.w();
                                                                        }
                                                                        ((TextView) tvActivity.Y.f12212a).setText("Favourites");
                                                                        break;
                                                                    default:
                                                                        x5.c cVar = tvActivity.f1551a0;
                                                                        if (cVar != null) {
                                                                            cVar.T();
                                                                        }
                                                                        break;
                                                                }
                                                            }
                                                        });
                                                        final int i15 = 3;
                                                        ((MaterialButton) this.Y.f12219j).setOnClickListener(new View.OnClickListener(this) { // from class: r5.p

                                                            /* JADX INFO: renamed from: w, reason: collision with root package name */
                                                            public final /* synthetic */ TvActivity f10882w;

                                                            {
                                                                this.f10882w = this;
                                                            }

                                                            @Override // android.view.View.OnClickListener
                                                            public final void onClick(View view) {
                                                                int i132 = i15;
                                                                TvActivity tvActivity = this.f10882w;
                                                                switch (i132) {
                                                                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                                                        ((DrawerLayout) tvActivity.X.f1801x).r();
                                                                        break;
                                                                    case 1:
                                                                        int i142 = TvActivity.f1550s0;
                                                                        tvActivity.x();
                                                                        break;
                                                                    case 2:
                                                                        if (tvActivity.f1553c0 == null) {
                                                                            ((f6.a) new v(tvActivity).s(f6.a.class, "categories")).f3975d = new q(tvActivity);
                                                                            x5.e eVar = new x5.e();
                                                                            Bundle bundle2 = new Bundle();
                                                                            bundle2.putString("tag", "categories");
                                                                            eVar.N(bundle2);
                                                                            tvActivity.f1553c0 = eVar;
                                                                            r0 r0VarO = tvActivity.o();
                                                                            androidx.fragment.app.a aVarF = l0.e.f(r0VarO, r0VarO);
                                                                            aVarF.f(q5.k.categories_fragment_container, tvActivity.f1553c0, null, 1);
                                                                            aVarF.e(false);
                                                                        }
                                                                        tvActivity.f1565p0 = false;
                                                                        tvActivity.o0 = false;
                                                                        ((FragmentContainerView) tvActivity.Z.f5927c).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Z.f5931h).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Z.f5930g).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Z.f5928d).setVisibility(8);
                                                                        tvActivity.f1562l0 = "Categories";
                                                                        ((TextView) tvActivity.Y.f12212a).setText("Categories");
                                                                        if (!tvActivity.f1563m0 || tvActivity.f1564n0) {
                                                                            tvActivity.f1564n0 = false;
                                                                            tvActivity.f1563m0 = false;
                                                                            tvActivity.f1551a0 = tvActivity.f1553c0;
                                                                            ((FragmentContainerView) tvActivity.Z.f5925a).setVisibility(0);
                                                                            ((FragmentContainerView) tvActivity.Z.f5926b).setVisibility(8);
                                                                        } else {
                                                                            tvActivity.f1564n0 = true;
                                                                            x5.i iVar = tvActivity.f1554d0;
                                                                            tvActivity.f1551a0 = iVar;
                                                                            tvActivity.W.C = iVar.f14350w0;
                                                                            ((TextView) tvActivity.Y.f12212a).setText(tvActivity.f1561k0);
                                                                            ((FragmentContainerView) tvActivity.Z.f5925a).setVisibility(8);
                                                                            ((FragmentContainerView) tvActivity.Z.f5926b).setVisibility(0);
                                                                        }
                                                                        if (tvActivity.f1566q0 == 0) {
                                                                            tvActivity.f1553c0.U("");
                                                                        }
                                                                        break;
                                                                    case 3:
                                                                        if (tvActivity.f1555e0 == null) {
                                                                            y5.a aVar2 = tvActivity.f1559i0;
                                                                            tvActivity.f1555e0 = x5.i.X(aVar2.f14904v, aVar2.f14905w, true);
                                                                            r0 r0VarO2 = tvActivity.o();
                                                                            androidx.fragment.app.a aVarF2 = l0.e.f(r0VarO2, r0VarO2);
                                                                            aVarF2.f(q5.k.sports_fragment_container, tvActivity.f1555e0, null, 1);
                                                                            aVarF2.e(false);
                                                                        }
                                                                        tvActivity.f1565p0 = false;
                                                                        tvActivity.o0 = false;
                                                                        tvActivity.f1564n0 = false;
                                                                        ((FragmentContainerView) tvActivity.Z.f5927c).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Z.f5925a).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Z.f5926b).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Z.f5928d).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Z.f5931h).setVisibility(0);
                                                                        tvActivity.f1551a0 = tvActivity.f1555e0;
                                                                        tvActivity.f1562l0 = "Sports";
                                                                        u5.a aVar3 = tvActivity.Y;
                                                                        if (aVar3 != null) {
                                                                            ((TextView) aVar3.f12212a).setText("Sports");
                                                                        }
                                                                        if (tvActivity.f1566q0 == 0) {
                                                                            tvActivity.f1553c0.U("");
                                                                        }
                                                                        break;
                                                                    case g1.h.LONG_FIELD_NUMBER /* 4 */:
                                                                        ((ImageView) tvActivity.Y.f12218h).setVisibility(0);
                                                                        ((EditText) tvActivity.Y.i).setVisibility(0);
                                                                        ((EditText) tvActivity.Y.i).setFocusable(true);
                                                                        ((EditText) tvActivity.Y.i).requestFocus();
                                                                        ((InputMethodManager) tvActivity.getSystemService("input_method")).showSoftInput((EditText) tvActivity.Y.i, 1);
                                                                        break;
                                                                    case g1.h.STRING_FIELD_NUMBER /* 5 */:
                                                                        int i152 = TvActivity.f1550s0;
                                                                        tvActivity.f1556f0 = new x5.l();
                                                                        r0 r0VarO3 = tvActivity.o();
                                                                        androidx.fragment.app.a aVarF3 = l0.e.f(r0VarO3, r0VarO3);
                                                                        aVarF3.f(q5.k.fav_fragment_container, tvActivity.f1556f0, null, 1);
                                                                        aVarF3.e(false);
                                                                        tvActivity.f1565p0 = true;
                                                                        ((FragmentContainerView) tvActivity.Z.f5928d).setVisibility(0);
                                                                        if (tvActivity.f1558h0 != null) {
                                                                            tvActivity.w();
                                                                        }
                                                                        ((TextView) tvActivity.Y.f12212a).setText("Favourites");
                                                                        break;
                                                                    default:
                                                                        x5.c cVar = tvActivity.f1551a0;
                                                                        if (cVar != null) {
                                                                            cVar.T();
                                                                        }
                                                                        break;
                                                                }
                                                            }
                                                        });
                                                        final int i16 = 4;
                                                        ((ImageButton) this.Y.f12217g).setOnClickListener(new View.OnClickListener(this) { // from class: r5.p

                                                            /* JADX INFO: renamed from: w, reason: collision with root package name */
                                                            public final /* synthetic */ TvActivity f10882w;

                                                            {
                                                                this.f10882w = this;
                                                            }

                                                            @Override // android.view.View.OnClickListener
                                                            public final void onClick(View view) {
                                                                int i132 = i16;
                                                                TvActivity tvActivity = this.f10882w;
                                                                switch (i132) {
                                                                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                                                        ((DrawerLayout) tvActivity.X.f1801x).r();
                                                                        break;
                                                                    case 1:
                                                                        int i142 = TvActivity.f1550s0;
                                                                        tvActivity.x();
                                                                        break;
                                                                    case 2:
                                                                        if (tvActivity.f1553c0 == null) {
                                                                            ((f6.a) new v(tvActivity).s(f6.a.class, "categories")).f3975d = new q(tvActivity);
                                                                            x5.e eVar = new x5.e();
                                                                            Bundle bundle2 = new Bundle();
                                                                            bundle2.putString("tag", "categories");
                                                                            eVar.N(bundle2);
                                                                            tvActivity.f1553c0 = eVar;
                                                                            r0 r0VarO = tvActivity.o();
                                                                            androidx.fragment.app.a aVarF = l0.e.f(r0VarO, r0VarO);
                                                                            aVarF.f(q5.k.categories_fragment_container, tvActivity.f1553c0, null, 1);
                                                                            aVarF.e(false);
                                                                        }
                                                                        tvActivity.f1565p0 = false;
                                                                        tvActivity.o0 = false;
                                                                        ((FragmentContainerView) tvActivity.Z.f5927c).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Z.f5931h).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Z.f5930g).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Z.f5928d).setVisibility(8);
                                                                        tvActivity.f1562l0 = "Categories";
                                                                        ((TextView) tvActivity.Y.f12212a).setText("Categories");
                                                                        if (!tvActivity.f1563m0 || tvActivity.f1564n0) {
                                                                            tvActivity.f1564n0 = false;
                                                                            tvActivity.f1563m0 = false;
                                                                            tvActivity.f1551a0 = tvActivity.f1553c0;
                                                                            ((FragmentContainerView) tvActivity.Z.f5925a).setVisibility(0);
                                                                            ((FragmentContainerView) tvActivity.Z.f5926b).setVisibility(8);
                                                                        } else {
                                                                            tvActivity.f1564n0 = true;
                                                                            x5.i iVar = tvActivity.f1554d0;
                                                                            tvActivity.f1551a0 = iVar;
                                                                            tvActivity.W.C = iVar.f14350w0;
                                                                            ((TextView) tvActivity.Y.f12212a).setText(tvActivity.f1561k0);
                                                                            ((FragmentContainerView) tvActivity.Z.f5925a).setVisibility(8);
                                                                            ((FragmentContainerView) tvActivity.Z.f5926b).setVisibility(0);
                                                                        }
                                                                        if (tvActivity.f1566q0 == 0) {
                                                                            tvActivity.f1553c0.U("");
                                                                        }
                                                                        break;
                                                                    case 3:
                                                                        if (tvActivity.f1555e0 == null) {
                                                                            y5.a aVar2 = tvActivity.f1559i0;
                                                                            tvActivity.f1555e0 = x5.i.X(aVar2.f14904v, aVar2.f14905w, true);
                                                                            r0 r0VarO2 = tvActivity.o();
                                                                            androidx.fragment.app.a aVarF2 = l0.e.f(r0VarO2, r0VarO2);
                                                                            aVarF2.f(q5.k.sports_fragment_container, tvActivity.f1555e0, null, 1);
                                                                            aVarF2.e(false);
                                                                        }
                                                                        tvActivity.f1565p0 = false;
                                                                        tvActivity.o0 = false;
                                                                        tvActivity.f1564n0 = false;
                                                                        ((FragmentContainerView) tvActivity.Z.f5927c).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Z.f5925a).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Z.f5926b).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Z.f5928d).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Z.f5931h).setVisibility(0);
                                                                        tvActivity.f1551a0 = tvActivity.f1555e0;
                                                                        tvActivity.f1562l0 = "Sports";
                                                                        u5.a aVar3 = tvActivity.Y;
                                                                        if (aVar3 != null) {
                                                                            ((TextView) aVar3.f12212a).setText("Sports");
                                                                        }
                                                                        if (tvActivity.f1566q0 == 0) {
                                                                            tvActivity.f1553c0.U("");
                                                                        }
                                                                        break;
                                                                    case g1.h.LONG_FIELD_NUMBER /* 4 */:
                                                                        ((ImageView) tvActivity.Y.f12218h).setVisibility(0);
                                                                        ((EditText) tvActivity.Y.i).setVisibility(0);
                                                                        ((EditText) tvActivity.Y.i).setFocusable(true);
                                                                        ((EditText) tvActivity.Y.i).requestFocus();
                                                                        ((InputMethodManager) tvActivity.getSystemService("input_method")).showSoftInput((EditText) tvActivity.Y.i, 1);
                                                                        break;
                                                                    case g1.h.STRING_FIELD_NUMBER /* 5 */:
                                                                        int i152 = TvActivity.f1550s0;
                                                                        tvActivity.f1556f0 = new x5.l();
                                                                        r0 r0VarO3 = tvActivity.o();
                                                                        androidx.fragment.app.a aVarF3 = l0.e.f(r0VarO3, r0VarO3);
                                                                        aVarF3.f(q5.k.fav_fragment_container, tvActivity.f1556f0, null, 1);
                                                                        aVarF3.e(false);
                                                                        tvActivity.f1565p0 = true;
                                                                        ((FragmentContainerView) tvActivity.Z.f5928d).setVisibility(0);
                                                                        if (tvActivity.f1558h0 != null) {
                                                                            tvActivity.w();
                                                                        }
                                                                        ((TextView) tvActivity.Y.f12212a).setText("Favourites");
                                                                        break;
                                                                    default:
                                                                        x5.c cVar = tvActivity.f1551a0;
                                                                        if (cVar != null) {
                                                                            cVar.T();
                                                                        }
                                                                        break;
                                                                }
                                                            }
                                                        });
                                                        final int i17 = 5;
                                                        ((MaterialButton) this.Y.f12215d).setOnClickListener(new View.OnClickListener(this) { // from class: r5.p

                                                            /* JADX INFO: renamed from: w, reason: collision with root package name */
                                                            public final /* synthetic */ TvActivity f10882w;

                                                            {
                                                                this.f10882w = this;
                                                            }

                                                            @Override // android.view.View.OnClickListener
                                                            public final void onClick(View view) {
                                                                int i132 = i17;
                                                                TvActivity tvActivity = this.f10882w;
                                                                switch (i132) {
                                                                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                                                        ((DrawerLayout) tvActivity.X.f1801x).r();
                                                                        break;
                                                                    case 1:
                                                                        int i142 = TvActivity.f1550s0;
                                                                        tvActivity.x();
                                                                        break;
                                                                    case 2:
                                                                        if (tvActivity.f1553c0 == null) {
                                                                            ((f6.a) new v(tvActivity).s(f6.a.class, "categories")).f3975d = new q(tvActivity);
                                                                            x5.e eVar = new x5.e();
                                                                            Bundle bundle2 = new Bundle();
                                                                            bundle2.putString("tag", "categories");
                                                                            eVar.N(bundle2);
                                                                            tvActivity.f1553c0 = eVar;
                                                                            r0 r0VarO = tvActivity.o();
                                                                            androidx.fragment.app.a aVarF = l0.e.f(r0VarO, r0VarO);
                                                                            aVarF.f(q5.k.categories_fragment_container, tvActivity.f1553c0, null, 1);
                                                                            aVarF.e(false);
                                                                        }
                                                                        tvActivity.f1565p0 = false;
                                                                        tvActivity.o0 = false;
                                                                        ((FragmentContainerView) tvActivity.Z.f5927c).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Z.f5931h).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Z.f5930g).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Z.f5928d).setVisibility(8);
                                                                        tvActivity.f1562l0 = "Categories";
                                                                        ((TextView) tvActivity.Y.f12212a).setText("Categories");
                                                                        if (!tvActivity.f1563m0 || tvActivity.f1564n0) {
                                                                            tvActivity.f1564n0 = false;
                                                                            tvActivity.f1563m0 = false;
                                                                            tvActivity.f1551a0 = tvActivity.f1553c0;
                                                                            ((FragmentContainerView) tvActivity.Z.f5925a).setVisibility(0);
                                                                            ((FragmentContainerView) tvActivity.Z.f5926b).setVisibility(8);
                                                                        } else {
                                                                            tvActivity.f1564n0 = true;
                                                                            x5.i iVar = tvActivity.f1554d0;
                                                                            tvActivity.f1551a0 = iVar;
                                                                            tvActivity.W.C = iVar.f14350w0;
                                                                            ((TextView) tvActivity.Y.f12212a).setText(tvActivity.f1561k0);
                                                                            ((FragmentContainerView) tvActivity.Z.f5925a).setVisibility(8);
                                                                            ((FragmentContainerView) tvActivity.Z.f5926b).setVisibility(0);
                                                                        }
                                                                        if (tvActivity.f1566q0 == 0) {
                                                                            tvActivity.f1553c0.U("");
                                                                        }
                                                                        break;
                                                                    case 3:
                                                                        if (tvActivity.f1555e0 == null) {
                                                                            y5.a aVar2 = tvActivity.f1559i0;
                                                                            tvActivity.f1555e0 = x5.i.X(aVar2.f14904v, aVar2.f14905w, true);
                                                                            r0 r0VarO2 = tvActivity.o();
                                                                            androidx.fragment.app.a aVarF2 = l0.e.f(r0VarO2, r0VarO2);
                                                                            aVarF2.f(q5.k.sports_fragment_container, tvActivity.f1555e0, null, 1);
                                                                            aVarF2.e(false);
                                                                        }
                                                                        tvActivity.f1565p0 = false;
                                                                        tvActivity.o0 = false;
                                                                        tvActivity.f1564n0 = false;
                                                                        ((FragmentContainerView) tvActivity.Z.f5927c).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Z.f5925a).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Z.f5926b).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Z.f5928d).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Z.f5931h).setVisibility(0);
                                                                        tvActivity.f1551a0 = tvActivity.f1555e0;
                                                                        tvActivity.f1562l0 = "Sports";
                                                                        u5.a aVar3 = tvActivity.Y;
                                                                        if (aVar3 != null) {
                                                                            ((TextView) aVar3.f12212a).setText("Sports");
                                                                        }
                                                                        if (tvActivity.f1566q0 == 0) {
                                                                            tvActivity.f1553c0.U("");
                                                                        }
                                                                        break;
                                                                    case g1.h.LONG_FIELD_NUMBER /* 4 */:
                                                                        ((ImageView) tvActivity.Y.f12218h).setVisibility(0);
                                                                        ((EditText) tvActivity.Y.i).setVisibility(0);
                                                                        ((EditText) tvActivity.Y.i).setFocusable(true);
                                                                        ((EditText) tvActivity.Y.i).requestFocus();
                                                                        ((InputMethodManager) tvActivity.getSystemService("input_method")).showSoftInput((EditText) tvActivity.Y.i, 1);
                                                                        break;
                                                                    case g1.h.STRING_FIELD_NUMBER /* 5 */:
                                                                        int i152 = TvActivity.f1550s0;
                                                                        tvActivity.f1556f0 = new x5.l();
                                                                        r0 r0VarO3 = tvActivity.o();
                                                                        androidx.fragment.app.a aVarF3 = l0.e.f(r0VarO3, r0VarO3);
                                                                        aVarF3.f(q5.k.fav_fragment_container, tvActivity.f1556f0, null, 1);
                                                                        aVarF3.e(false);
                                                                        tvActivity.f1565p0 = true;
                                                                        ((FragmentContainerView) tvActivity.Z.f5928d).setVisibility(0);
                                                                        if (tvActivity.f1558h0 != null) {
                                                                            tvActivity.w();
                                                                        }
                                                                        ((TextView) tvActivity.Y.f12212a).setText("Favourites");
                                                                        break;
                                                                    default:
                                                                        x5.c cVar = tvActivity.f1551a0;
                                                                        if (cVar != null) {
                                                                            cVar.T();
                                                                        }
                                                                        break;
                                                                }
                                                            }
                                                        });
                                                        final int i18 = 6;
                                                        ((ImageButton) this.Y.f).setOnClickListener(new View.OnClickListener(this) { // from class: r5.p

                                                            /* JADX INFO: renamed from: w, reason: collision with root package name */
                                                            public final /* synthetic */ TvActivity f10882w;

                                                            {
                                                                this.f10882w = this;
                                                            }

                                                            @Override // android.view.View.OnClickListener
                                                            public final void onClick(View view) {
                                                                int i132 = i18;
                                                                TvActivity tvActivity = this.f10882w;
                                                                switch (i132) {
                                                                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                                                        ((DrawerLayout) tvActivity.X.f1801x).r();
                                                                        break;
                                                                    case 1:
                                                                        int i142 = TvActivity.f1550s0;
                                                                        tvActivity.x();
                                                                        break;
                                                                    case 2:
                                                                        if (tvActivity.f1553c0 == null) {
                                                                            ((f6.a) new v(tvActivity).s(f6.a.class, "categories")).f3975d = new q(tvActivity);
                                                                            x5.e eVar = new x5.e();
                                                                            Bundle bundle2 = new Bundle();
                                                                            bundle2.putString("tag", "categories");
                                                                            eVar.N(bundle2);
                                                                            tvActivity.f1553c0 = eVar;
                                                                            r0 r0VarO = tvActivity.o();
                                                                            androidx.fragment.app.a aVarF = l0.e.f(r0VarO, r0VarO);
                                                                            aVarF.f(q5.k.categories_fragment_container, tvActivity.f1553c0, null, 1);
                                                                            aVarF.e(false);
                                                                        }
                                                                        tvActivity.f1565p0 = false;
                                                                        tvActivity.o0 = false;
                                                                        ((FragmentContainerView) tvActivity.Z.f5927c).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Z.f5931h).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Z.f5930g).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Z.f5928d).setVisibility(8);
                                                                        tvActivity.f1562l0 = "Categories";
                                                                        ((TextView) tvActivity.Y.f12212a).setText("Categories");
                                                                        if (!tvActivity.f1563m0 || tvActivity.f1564n0) {
                                                                            tvActivity.f1564n0 = false;
                                                                            tvActivity.f1563m0 = false;
                                                                            tvActivity.f1551a0 = tvActivity.f1553c0;
                                                                            ((FragmentContainerView) tvActivity.Z.f5925a).setVisibility(0);
                                                                            ((FragmentContainerView) tvActivity.Z.f5926b).setVisibility(8);
                                                                        } else {
                                                                            tvActivity.f1564n0 = true;
                                                                            x5.i iVar = tvActivity.f1554d0;
                                                                            tvActivity.f1551a0 = iVar;
                                                                            tvActivity.W.C = iVar.f14350w0;
                                                                            ((TextView) tvActivity.Y.f12212a).setText(tvActivity.f1561k0);
                                                                            ((FragmentContainerView) tvActivity.Z.f5925a).setVisibility(8);
                                                                            ((FragmentContainerView) tvActivity.Z.f5926b).setVisibility(0);
                                                                        }
                                                                        if (tvActivity.f1566q0 == 0) {
                                                                            tvActivity.f1553c0.U("");
                                                                        }
                                                                        break;
                                                                    case 3:
                                                                        if (tvActivity.f1555e0 == null) {
                                                                            y5.a aVar2 = tvActivity.f1559i0;
                                                                            tvActivity.f1555e0 = x5.i.X(aVar2.f14904v, aVar2.f14905w, true);
                                                                            r0 r0VarO2 = tvActivity.o();
                                                                            androidx.fragment.app.a aVarF2 = l0.e.f(r0VarO2, r0VarO2);
                                                                            aVarF2.f(q5.k.sports_fragment_container, tvActivity.f1555e0, null, 1);
                                                                            aVarF2.e(false);
                                                                        }
                                                                        tvActivity.f1565p0 = false;
                                                                        tvActivity.o0 = false;
                                                                        tvActivity.f1564n0 = false;
                                                                        ((FragmentContainerView) tvActivity.Z.f5927c).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Z.f5925a).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Z.f5926b).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Z.f5928d).setVisibility(8);
                                                                        ((FragmentContainerView) tvActivity.Z.f5931h).setVisibility(0);
                                                                        tvActivity.f1551a0 = tvActivity.f1555e0;
                                                                        tvActivity.f1562l0 = "Sports";
                                                                        u5.a aVar3 = tvActivity.Y;
                                                                        if (aVar3 != null) {
                                                                            ((TextView) aVar3.f12212a).setText("Sports");
                                                                        }
                                                                        if (tvActivity.f1566q0 == 0) {
                                                                            tvActivity.f1553c0.U("");
                                                                        }
                                                                        break;
                                                                    case g1.h.LONG_FIELD_NUMBER /* 4 */:
                                                                        ((ImageView) tvActivity.Y.f12218h).setVisibility(0);
                                                                        ((EditText) tvActivity.Y.i).setVisibility(0);
                                                                        ((EditText) tvActivity.Y.i).setFocusable(true);
                                                                        ((EditText) tvActivity.Y.i).requestFocus();
                                                                        ((InputMethodManager) tvActivity.getSystemService("input_method")).showSoftInput((EditText) tvActivity.Y.i, 1);
                                                                        break;
                                                                    case g1.h.STRING_FIELD_NUMBER /* 5 */:
                                                                        int i152 = TvActivity.f1550s0;
                                                                        tvActivity.f1556f0 = new x5.l();
                                                                        r0 r0VarO3 = tvActivity.o();
                                                                        androidx.fragment.app.a aVarF3 = l0.e.f(r0VarO3, r0VarO3);
                                                                        aVarF3.f(q5.k.fav_fragment_container, tvActivity.f1556f0, null, 1);
                                                                        aVarF3.e(false);
                                                                        tvActivity.f1565p0 = true;
                                                                        ((FragmentContainerView) tvActivity.Z.f5928d).setVisibility(0);
                                                                        if (tvActivity.f1558h0 != null) {
                                                                            tvActivity.w();
                                                                        }
                                                                        ((TextView) tvActivity.Y.f12212a).setText("Favourites");
                                                                        break;
                                                                    default:
                                                                        x5.c cVar = tvActivity.f1551a0;
                                                                        if (cVar != null) {
                                                                            cVar.T();
                                                                        }
                                                                        break;
                                                                }
                                                            }
                                                        });
                                                        ((NavigationView) this.X.f1802y).setNavigationItemSelectedListener(new q(this));
                                                        x();
                                                        ((EditText) this.Y.i).addTextChangedListener(new s2(this, 1));
                                                        ((EditText) this.Y.i).setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: r5.r
                                                            @Override // android.widget.TextView.OnEditorActionListener
                                                            public final boolean onEditorAction(TextView textView2, int i19, KeyEvent keyEvent) {
                                                                int i20 = TvActivity.f1550s0;
                                                                if (i19 != 6) {
                                                                    return false;
                                                                }
                                                                TvActivity tvActivity = this.f10884a;
                                                                ((InputMethodManager) tvActivity.getSystemService("input_method")).hideSoftInputFromWindow(((EditText) tvActivity.Y.i).getWindowToken(), 0);
                                                                return true;
                                                            }
                                                        });
                                                        o().a0(this, new q(this));
                                                        String str2 = this.f1559i0.H;
                                                        if (str2 == null || !str2.trim().startsWith("http")) {
                                                            str = null;
                                                        } else {
                                                            String str3 = this.f1559i0.I;
                                                            b bVar = new b();
                                                            Bundle bundle2 = new Bundle();
                                                            bundle2.putString("arg_ad", str2);
                                                            bundle2.putString("arg_action", str3);
                                                            bVar.N(bundle2);
                                                            this.f1557g0 = bVar;
                                                            r0 r0VarO = o();
                                                            androidx.fragment.app.a aVarF = l0.e.f(r0VarO, r0VarO);
                                                            aVarF.f912b = R.anim.fade_in;
                                                            aVarF.f913c = R.anim.fade_out;
                                                            aVarF.f914d = 0;
                                                            aVarF.f915e = 0;
                                                            str = null;
                                                            aVarF.f(R.id.content, this.f1557g0, null, 1);
                                                            aVarF.c(null);
                                                            aVarF.e(false);
                                                        }
                                                        this.W.f1571y = new q(this);
                                                        File externalFilesDir = getExternalFilesDir(str);
                                                        if (externalFilesDir == null) {
                                                            return;
                                                        }
                                                        l4.a.E(externalFilesDir);
                                                        return;
                                                    }
                                                    i10 = i11;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                throw new NullPointerException("Missing required view with ID: ".concat(viewL.getResources().getResourceName(i10)));
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    public final void w() {
        ((FragmentContainerView) this.Z.f).setVisibility(8);
        r0 r0VarO = o();
        r0VarO.getClass();
        androidx.fragment.app.a aVar = new androidx.fragment.app.a(r0VarO);
        aVar.h(this.f1558h0);
        aVar.e(false);
        this.f1558h0 = null;
    }

    public final void x() {
        if (this.f1552b0 == null) {
            f6.b bVar = (f6.b) new v(this).r(f6.b.class);
            y5.a aVar = this.f1559i0;
            bVar.f3977e = aVar.B;
            bVar.f = aVar.C;
            bVar.f3978g = aVar.F;
            bVar.f3979h = aVar.G;
            this.f1552b0 = new k();
            r0 r0VarO = o();
            androidx.fragment.app.a aVarF = l0.e.f(r0VarO, r0VarO);
            aVarF.f(q5.k.events_fragment_container, this.f1552b0, null, 1);
            aVarF.e(false);
        }
        this.o0 = true;
        this.f1565p0 = false;
        this.f1564n0 = false;
        this.f1551a0 = this.f1552b0;
        ((FragmentContainerView) this.Z.f5927c).setVisibility(0);
        ((FragmentContainerView) this.Z.f5931h).setVisibility(8);
        ((FragmentContainerView) this.Z.f5930g).setVisibility(8);
        ((FragmentContainerView) this.Z.f5925a).setVisibility(8);
        ((FragmentContainerView) this.Z.f5926b).setVisibility(8);
        ((FragmentContainerView) this.Z.f5928d).setVisibility(8);
        String str = this.f1560j0;
        this.f1562l0 = str;
        ((TextView) this.Y.f12212a).setText(str);
    }
}
