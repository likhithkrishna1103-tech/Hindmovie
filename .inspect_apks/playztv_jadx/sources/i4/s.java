package i4;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.media3.ui.DefaultTimeBar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;
import java.util.Collections;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;
import p1.c1;
import p1.e1;
import p1.f1;
import p1.l1;
import p1.m1;
import p1.n1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class s extends FrameLayout {
    public static final float[] S0;
    public final k A;
    public final String A0;
    public final g B;
    public p1.w0 B0;
    public final g C;
    public i C0;
    public final e D;
    public boolean D0;
    public final PopupWindow E;
    public boolean E0;
    public final int F;
    public boolean F0;
    public final View G;
    public boolean G0;
    public final View H;
    public boolean H0;
    public final View I;
    public boolean I0;
    public final View J;
    public int J0;
    public final View K;
    public int K0;
    public final TextView L;
    public int L0;
    public final TextView M;
    public long[] M0;
    public final ImageView N;
    public boolean[] N0;
    public final ImageView O;
    public final long[] O0;
    public final View P;
    public final boolean[] P0;
    public final ImageView Q;
    public long Q0;
    public final ImageView R;
    public boolean R0;
    public final ImageView S;
    public final View T;
    public final View U;
    public final View V;
    public final TextView W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public final TextView f6259a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public final u0 f6260b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public final StringBuilder f6261c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public final Formatter f6262d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public final c1 f6263e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public final e1 f6264f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public final a2.a f6265g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public final Drawable f6266h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public final Drawable f6267i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public final Drawable f6268j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public final String f6269k0;
    public final String l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public final String f6270m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public final Drawable f6271n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public final Drawable f6272o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public final float f6273p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public final float f6274q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public final String f6275r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public final String f6276s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public final Drawable f6277t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final x f6278u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public final Drawable f6279u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Resources f6280v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public final String f6281v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final h f6282w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public final String f6283w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final CopyOnWriteArrayList f6284x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public final Drawable f6285x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final RecyclerView f6286y;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public final Drawable f6287y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final n f6288z;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public final String f6289z0;

    static {
        p1.h0.a("media3.ui");
        S0 = new float[]{0.25f, 0.5f, 0.75f, 1.0f, 1.25f, 1.5f, 2.0f};
    }

    public s(Context context, AttributeSet attributeSet) {
        boolean z2;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        ImageView imageView;
        h hVar;
        boolean z18;
        boolean z19;
        Typeface typefaceB;
        int i;
        super(context, null, 0);
        int resourceId = j0.exo_player_control_view;
        this.G0 = true;
        this.J0 = 5000;
        this.L0 = 0;
        this.K0 = 200;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, n0.PlayerControlView, 0, 0);
            try {
                resourceId = typedArrayObtainStyledAttributes.getResourceId(n0.PlayerControlView_controller_layout_id, resourceId);
                this.J0 = typedArrayObtainStyledAttributes.getInt(n0.PlayerControlView_show_timeout, this.J0);
                this.L0 = typedArrayObtainStyledAttributes.getInt(n0.PlayerControlView_repeat_toggle_modes, this.L0);
                boolean z20 = typedArrayObtainStyledAttributes.getBoolean(n0.PlayerControlView_show_rewind_button, true);
                boolean z21 = typedArrayObtainStyledAttributes.getBoolean(n0.PlayerControlView_show_fastforward_button, true);
                boolean z22 = typedArrayObtainStyledAttributes.getBoolean(n0.PlayerControlView_show_previous_button, true);
                boolean z23 = typedArrayObtainStyledAttributes.getBoolean(n0.PlayerControlView_show_next_button, true);
                boolean z24 = typedArrayObtainStyledAttributes.getBoolean(n0.PlayerControlView_show_shuffle_button, false);
                boolean z25 = typedArrayObtainStyledAttributes.getBoolean(n0.PlayerControlView_show_subtitle_button, false);
                boolean z26 = typedArrayObtainStyledAttributes.getBoolean(n0.PlayerControlView_show_vr_button, false);
                setTimeBarMinUpdateInterval(typedArrayObtainStyledAttributes.getInt(n0.PlayerControlView_time_bar_min_update_interval, this.K0));
                boolean z27 = typedArrayObtainStyledAttributes.getBoolean(n0.PlayerControlView_animation_enabled, true);
                typedArrayObtainStyledAttributes.recycle();
                z16 = z27;
                z2 = z24;
                z12 = z20;
                z13 = z21;
                z10 = z25;
                z11 = z26;
                z14 = z22;
                z15 = z23;
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes.recycle();
                throw th;
            }
        } else {
            z2 = false;
            z10 = false;
            z11 = false;
            z12 = true;
            z13 = true;
            z14 = true;
            z15 = true;
            z16 = true;
        }
        LayoutInflater.from(context).inflate(resourceId, this);
        setDescendantFocusability(262144);
        h hVar2 = new h(this);
        this.f6282w = hVar2;
        this.f6284x = new CopyOnWriteArrayList();
        this.f6263e0 = new c1();
        this.f6264f0 = new e1();
        StringBuilder sb2 = new StringBuilder();
        this.f6261c0 = sb2;
        this.f6262d0 = new Formatter(sb2, Locale.getDefault());
        this.M0 = new long[0];
        this.N0 = new boolean[0];
        this.O0 = new long[0];
        this.P0 = new boolean[0];
        this.f6265g0 = new a2.a(22, this);
        this.W = (TextView) findViewById(h0.exo_duration);
        this.f6259a0 = (TextView) findViewById(h0.exo_position);
        ImageView imageView2 = (ImageView) findViewById(h0.exo_subtitle);
        this.Q = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(hVar2);
        }
        ImageView imageView3 = (ImageView) findViewById(h0.exo_fullscreen);
        this.R = imageView3;
        com.google.android.material.datepicker.n nVar = new com.google.android.material.datepicker.n(2, this);
        if (imageView3 != null) {
            imageView3.setVisibility(8);
            imageView3.setOnClickListener(nVar);
        }
        ImageView imageView4 = (ImageView) findViewById(h0.exo_minimal_fullscreen);
        this.S = imageView4;
        com.google.android.material.datepicker.n nVar2 = new com.google.android.material.datepicker.n(2, this);
        if (imageView4 != null) {
            imageView4.setVisibility(8);
            imageView4.setOnClickListener(nVar2);
        }
        View viewFindViewById = findViewById(h0.exo_settings);
        this.T = viewFindViewById;
        if (viewFindViewById != null) {
            viewFindViewById.setOnClickListener(hVar2);
        }
        View viewFindViewById2 = findViewById(h0.exo_playback_speed);
        this.U = viewFindViewById2;
        if (viewFindViewById2 != null) {
            viewFindViewById2.setOnClickListener(hVar2);
        }
        View viewFindViewById3 = findViewById(h0.exo_audio_track);
        this.V = viewFindViewById3;
        if (viewFindViewById3 != null) {
            viewFindViewById3.setOnClickListener(hVar2);
        }
        u0 u0Var = (u0) findViewById(h0.exo_progress);
        View viewFindViewById4 = findViewById(h0.exo_progress_placeholder);
        if (u0Var != null) {
            this.f6260b0 = u0Var;
            z17 = z2;
        } else if (viewFindViewById4 != null) {
            z17 = z2;
            DefaultTimeBar defaultTimeBar = new DefaultTimeBar(context, null, attributeSet, m0.ExoStyledControls_TimeBar);
            defaultTimeBar.setId(h0.exo_progress);
            defaultTimeBar.setLayoutParams(viewFindViewById4.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) viewFindViewById4.getParent();
            int iIndexOfChild = viewGroup.indexOfChild(viewFindViewById4);
            viewGroup.removeView(viewFindViewById4);
            viewGroup.addView(defaultTimeBar, iIndexOfChild);
            this.f6260b0 = defaultTimeBar;
        } else {
            z17 = z2;
            this.f6260b0 = null;
        }
        u0 u0Var2 = this.f6260b0;
        if (u0Var2 != null) {
            ((DefaultTimeBar) u0Var2).R.add(hVar2);
        }
        View viewFindViewById5 = findViewById(h0.exo_play_pause);
        this.I = viewFindViewById5;
        if (viewFindViewById5 != null) {
            viewFindViewById5.setOnClickListener(hVar2);
        }
        View viewFindViewById6 = findViewById(h0.exo_prev);
        this.G = viewFindViewById6;
        if (viewFindViewById6 != null) {
            viewFindViewById6.setOnClickListener(hVar2);
        }
        View viewFindViewById7 = findViewById(h0.exo_next);
        this.H = viewFindViewById7;
        if (viewFindViewById7 != null) {
            viewFindViewById7.setOnClickListener(hVar2);
        }
        int i10 = g0.roboto_medium_numbers;
        ThreadLocal threadLocal = h0.k.f5599a;
        if (context.isRestricted()) {
            z18 = z10;
            z19 = z11;
            imageView = imageView2;
            hVar = hVar2;
            typefaceB = null;
        } else {
            imageView = imageView2;
            hVar = hVar2;
            z18 = z10;
            z19 = z11;
            typefaceB = h0.k.b(context, i10, new TypedValue(), 0, null, false, false);
        }
        View viewFindViewById8 = findViewById(h0.exo_rew);
        TextView textView = viewFindViewById8 == null ? (TextView) findViewById(h0.exo_rew_with_amount) : null;
        this.M = textView;
        if (textView != null) {
            textView.setTypeface(typefaceB);
        }
        viewFindViewById8 = viewFindViewById8 == null ? textView : viewFindViewById8;
        this.K = viewFindViewById8;
        if (viewFindViewById8 != null) {
            viewFindViewById8.setOnClickListener(hVar);
        }
        View viewFindViewById9 = findViewById(h0.exo_ffwd);
        TextView textView2 = viewFindViewById9 == null ? (TextView) findViewById(h0.exo_ffwd_with_amount) : null;
        this.L = textView2;
        if (textView2 != null) {
            textView2.setTypeface(typefaceB);
        }
        viewFindViewById9 = viewFindViewById9 == null ? textView2 : viewFindViewById9;
        this.J = viewFindViewById9;
        if (viewFindViewById9 != null) {
            viewFindViewById9.setOnClickListener(hVar);
        }
        ImageView imageView5 = (ImageView) findViewById(h0.exo_repeat_toggle);
        this.N = imageView5;
        if (imageView5 != null) {
            imageView5.setOnClickListener(hVar);
        }
        ImageView imageView6 = (ImageView) findViewById(h0.exo_shuffle);
        this.O = imageView6;
        if (imageView6 != null) {
            imageView6.setOnClickListener(hVar);
        }
        Resources resources = context.getResources();
        this.f6280v = resources;
        this.f6273p0 = resources.getInteger(i0.exo_media_button_opacity_percentage_enabled) / 100.0f;
        this.f6274q0 = resources.getInteger(i0.exo_media_button_opacity_percentage_disabled) / 100.0f;
        View viewFindViewById10 = findViewById(h0.exo_vr);
        this.P = viewFindViewById10;
        if (viewFindViewById10 != null) {
            k(viewFindViewById10, false);
        }
        x xVar = new x(this);
        this.f6278u = xVar;
        xVar.C = z16;
        n nVar3 = new n(this, new String[]{resources.getString(l0.exo_controls_playback_speed), resources.getString(l0.exo_track_selection_title_audio)}, new Drawable[]{resources.getDrawable(f0.exo_styled_controls_speed, context.getTheme()), resources.getDrawable(f0.exo_styled_controls_audiotrack, context.getTheme())});
        this.f6288z = nVar3;
        this.F = resources.getDimensionPixelSize(e0.exo_settings_offset);
        RecyclerView recyclerView = (RecyclerView) LayoutInflater.from(context).inflate(j0.exo_styled_settings_list, (ViewGroup) null);
        this.f6286y = recyclerView;
        recyclerView.setAdapter(nVar3);
        getContext();
        recyclerView.setLayoutManager(new LinearLayoutManager(1));
        PopupWindow popupWindow = new PopupWindow((View) recyclerView, -2, -2, true);
        this.E = popupWindow;
        if (s1.b0.f11647a < 23) {
            i = 0;
            popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        } else {
            i = 0;
        }
        popupWindow.setOnDismissListener(hVar);
        this.R0 = true;
        this.D = new e(getResources(), i);
        this.f6277t0 = resources.getDrawable(f0.exo_styled_controls_subtitle_on, context.getTheme());
        this.f6279u0 = resources.getDrawable(f0.exo_styled_controls_subtitle_off, context.getTheme());
        this.f6281v0 = resources.getString(l0.exo_controls_cc_enabled_description);
        this.f6283w0 = resources.getString(l0.exo_controls_cc_disabled_description);
        this.B = new g(this, 1);
        this.C = new g(this, 0);
        this.A = new k(this, resources.getStringArray(c0.exo_controls_playback_speeds), S0);
        this.f6285x0 = resources.getDrawable(f0.exo_styled_controls_fullscreen_exit, context.getTheme());
        this.f6287y0 = resources.getDrawable(f0.exo_styled_controls_fullscreen_enter, context.getTheme());
        this.f6266h0 = resources.getDrawable(f0.exo_styled_controls_repeat_off, context.getTheme());
        this.f6267i0 = resources.getDrawable(f0.exo_styled_controls_repeat_one, context.getTheme());
        this.f6268j0 = resources.getDrawable(f0.exo_styled_controls_repeat_all, context.getTheme());
        this.f6271n0 = resources.getDrawable(f0.exo_styled_controls_shuffle_on, context.getTheme());
        this.f6272o0 = resources.getDrawable(f0.exo_styled_controls_shuffle_off, context.getTheme());
        this.f6289z0 = resources.getString(l0.exo_controls_fullscreen_exit_description);
        this.A0 = resources.getString(l0.exo_controls_fullscreen_enter_description);
        this.f6269k0 = resources.getString(l0.exo_controls_repeat_off_description);
        this.l0 = resources.getString(l0.exo_controls_repeat_one_description);
        this.f6270m0 = resources.getString(l0.exo_controls_repeat_all_description);
        this.f6275r0 = resources.getString(l0.exo_controls_shuffle_on_description);
        this.f6276s0 = resources.getString(l0.exo_controls_shuffle_off_description);
        xVar.h((ViewGroup) findViewById(h0.exo_bottom_bar), true);
        xVar.h(viewFindViewById9, z13);
        xVar.h(viewFindViewById8, z12);
        xVar.h(viewFindViewById6, z14);
        xVar.h(viewFindViewById7, z15);
        xVar.h(imageView6, z17);
        xVar.h(imageView, z18);
        xVar.h(viewFindViewById10, z19);
        xVar.h(imageView5, this.L0 != 0);
        addOnLayoutChangeListener(new f(0, this));
    }

    public static void a(s sVar) {
        String str = sVar.A0;
        Drawable drawable = sVar.f6287y0;
        String str2 = sVar.f6289z0;
        Drawable drawable2 = sVar.f6285x0;
        if (sVar.C0 == null) {
            return;
        }
        boolean z2 = sVar.D0;
        sVar.D0 = !z2;
        ImageView imageView = sVar.R;
        if (imageView != null) {
            if (z2) {
                imageView.setImageDrawable(drawable);
                imageView.setContentDescription(str);
            } else {
                imageView.setImageDrawable(drawable2);
                imageView.setContentDescription(str2);
            }
        }
        ImageView imageView2 = sVar.S;
        boolean z10 = sVar.D0;
        if (imageView2 == null) {
            return;
        }
        if (z10) {
            imageView2.setImageDrawable(drawable2);
            imageView2.setContentDescription(str2);
        } else {
            imageView2.setImageDrawable(drawable);
            imageView2.setContentDescription(str);
        }
    }

    public static boolean c(p1.w0 w0Var, e1 e1Var) {
        f1 f1VarW0;
        int iO;
        if (!w0Var.e0(17) || (iO = (f1VarW0 = w0Var.w0()).o()) <= 1 || iO > 100) {
            return false;
        }
        for (int i = 0; i < iO; i++) {
            if (f1VarW0.m(i, e1Var, 0L).f9723m == -9223372036854775807L) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlaybackSpeed(float f) {
        p1.w0 w0Var = this.B0;
        if (w0Var == null || !w0Var.e0(13)) {
            return;
        }
        p1.w0 w0Var2 = this.B0;
        w0Var2.e(new p1.q0(f, w0Var2.h().f10039b));
    }

    public final boolean d(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        p1.w0 w0Var = this.B0;
        if (w0Var == null) {
            return false;
        }
        if (keyCode != 90 && keyCode != 89 && keyCode != 85 && keyCode != 79 && keyCode != 126 && keyCode != 127 && keyCode != 87 && keyCode != 88) {
            return false;
        }
        if (keyEvent.getAction() == 0) {
            if (keyCode == 90) {
                if (w0Var.I() != 4 && w0Var.e0(12)) {
                    w0Var.K0();
                }
            } else if (keyCode == 89 && w0Var.e0(11)) {
                w0Var.M0();
            } else if (keyEvent.getRepeatCount() == 0) {
                if (keyCode == 79 || keyCode == 85) {
                    if (s1.b0.Y(w0Var, this.G0)) {
                        s1.b0.F(w0Var);
                    } else if (w0Var.e0(1)) {
                        w0Var.f();
                    }
                } else if (keyCode != 87) {
                    if (keyCode != 88) {
                        if (keyCode == 126) {
                            s1.b0.F(w0Var);
                        } else if (keyCode == 127) {
                            int i = s1.b0.f11647a;
                            if (w0Var.e0(1)) {
                                w0Var.f();
                            }
                        }
                    } else if (w0Var.e0(7)) {
                        w0Var.R0();
                    }
                } else if (w0Var.e0(9)) {
                    w0Var.J0();
                }
            }
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return d(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public final void e(q4.z zVar, View view) {
        this.f6286y.setAdapter(zVar);
        q();
        this.R0 = false;
        PopupWindow popupWindow = this.E;
        popupWindow.dismiss();
        this.R0 = true;
        int width = getWidth() - popupWindow.getWidth();
        int i = this.F;
        popupWindow.showAsDropDown(view, width - i, (-popupWindow.getHeight()) - i);
    }

    public final aa.c1 f(n1 n1Var, int i) {
        aa.q.c("initialCapacity", 4);
        Object[] objArrCopyOf = new Object[4];
        aa.j0 j0Var = n1Var.f9952a;
        int i10 = 0;
        for (int i11 = 0; i11 < j0Var.size(); i11++) {
            m1 m1Var = (m1) j0Var.get(i11);
            if (m1Var.f9944b.f9764c == i) {
                for (int i12 = 0; i12 < m1Var.f9943a; i12++) {
                    if (m1Var.f9946d[i12] == 4) {
                        p1.q qVar = m1Var.f9944b.f9765d[i12];
                        if ((qVar.f10016e & 2) == 0) {
                            p pVar = new p(n1Var, i11, i12, this.D.c(qVar));
                            int i13 = i10 + 1;
                            int iF = aa.d0.f(objArrCopyOf.length, i13);
                            if (iF > objArrCopyOf.length) {
                                objArrCopyOf = Arrays.copyOf(objArrCopyOf, iF);
                            }
                            objArrCopyOf[i10] = pVar;
                            i10 = i13;
                        }
                    }
                }
            }
        }
        return aa.j0.l(i10, objArrCopyOf);
    }

    public final void g() {
        x xVar = this.f6278u;
        int i = xVar.f6348z;
        if (i == 3 || i == 2) {
            return;
        }
        xVar.f();
        if (!xVar.C) {
            xVar.i(2);
        } else if (xVar.f6348z == 1) {
            xVar.f6335m.start();
        } else {
            xVar.f6336n.start();
        }
    }

    public p1.w0 getPlayer() {
        return this.B0;
    }

    public int getRepeatToggleModes() {
        return this.L0;
    }

    public boolean getShowShuffleButton() {
        return this.f6278u.b(this.O);
    }

    public boolean getShowSubtitleButton() {
        return this.f6278u.b(this.Q);
    }

    public int getShowTimeoutMs() {
        return this.J0;
    }

    public boolean getShowVrButton() {
        return this.f6278u.b(this.P);
    }

    public final boolean h() {
        x xVar = this.f6278u;
        return xVar.f6348z == 0 && xVar.f6325a.i();
    }

    public final boolean i() {
        return getVisibility() == 0;
    }

    public final void j() {
        m();
        l();
        p();
        r();
        t();
        n();
        s();
    }

    public final void k(View view, boolean z2) {
        if (view == null) {
            return;
        }
        view.setEnabled(z2);
        view.setAlpha(z2 ? this.f6273p0 : this.f6274q0);
    }

    public final void l() {
        boolean zE0;
        boolean zE02;
        boolean zE03;
        boolean zE04;
        boolean zE05;
        if (i() && this.E0) {
            p1.w0 w0Var = this.B0;
            if (w0Var != null) {
                zE02 = (this.F0 && c(w0Var, this.f6264f0)) ? w0Var.e0(10) : w0Var.e0(5);
                zE03 = w0Var.e0(7);
                zE04 = w0Var.e0(11);
                zE05 = w0Var.e0(12);
                zE0 = w0Var.e0(9);
            } else {
                zE0 = false;
                zE02 = false;
                zE03 = false;
                zE04 = false;
                zE05 = false;
            }
            Resources resources = this.f6280v;
            View view = this.K;
            if (zE04) {
                p1.w0 w0Var2 = this.B0;
                int iV0 = (int) ((w0Var2 != null ? w0Var2.V0() : 5000L) / 1000);
                TextView textView = this.M;
                if (textView != null) {
                    textView.setText(String.valueOf(iV0));
                }
                if (view != null) {
                    view.setContentDescription(resources.getQuantityString(k0.exo_controls_rewind_by_amount_description, iV0, Integer.valueOf(iV0)));
                }
            }
            View view2 = this.J;
            if (zE05) {
                p1.w0 w0Var3 = this.B0;
                int iQ = (int) ((w0Var3 != null ? w0Var3.q() : 15000L) / 1000);
                TextView textView2 = this.L;
                if (textView2 != null) {
                    textView2.setText(String.valueOf(iQ));
                }
                if (view2 != null) {
                    view2.setContentDescription(resources.getQuantityString(k0.exo_controls_fastforward_by_amount_description, iQ, Integer.valueOf(iQ)));
                }
            }
            k(this.G, zE03);
            k(view, zE04);
            k(view2, zE05);
            k(this.H, zE0);
            u0 u0Var = this.f6260b0;
            if (u0Var != null) {
                u0Var.setEnabled(zE02);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m() {
        /*
            r6 = this;
            boolean r0 = r6.i()
            if (r0 == 0) goto L66
            boolean r0 = r6.E0
            if (r0 != 0) goto Lb
            goto L66
        Lb:
            android.view.View r0 = r6.I
            if (r0 == 0) goto L66
            p1.w0 r1 = r6.B0
            boolean r2 = r6.G0
            boolean r1 = s1.b0.Y(r1, r2)
            if (r1 == 0) goto L1c
            int r2 = i4.f0.exo_styled_controls_play
            goto L1e
        L1c:
            int r2 = i4.f0.exo_styled_controls_pause
        L1e:
            if (r1 == 0) goto L23
            int r1 = i4.l0.exo_controls_play_description
            goto L25
        L23:
            int r1 = i4.l0.exo_controls_pause_description
        L25:
            r3 = r0
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            android.content.Context r4 = r6.getContext()
            android.content.res.Resources$Theme r4 = r4.getTheme()
            android.content.res.Resources r5 = r6.f6280v
            android.graphics.drawable.Drawable r2 = r5.getDrawable(r2, r4)
            r3.setImageDrawable(r2)
            java.lang.String r1 = r5.getString(r1)
            r0.setContentDescription(r1)
            p1.w0 r1 = r6.B0
            if (r1 == 0) goto L62
            r2 = 1
            boolean r1 = r1.e0(r2)
            if (r1 == 0) goto L62
            p1.w0 r1 = r6.B0
            r3 = 17
            boolean r1 = r1.e0(r3)
            if (r1 == 0) goto L63
            p1.w0 r1 = r6.B0
            p1.f1 r1 = r1.w0()
            boolean r1 = r1.p()
            if (r1 != 0) goto L62
            goto L63
        L62:
            r2 = 0
        L63:
            r6.k(r0, r2)
        L66:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i4.s.m():void");
    }

    public final void n() {
        k kVar;
        p1.w0 w0Var = this.B0;
        if (w0Var == null) {
            return;
        }
        float f = w0Var.h().f10038a;
        float f4 = Float.MAX_VALUE;
        int i = 0;
        int i10 = 0;
        while (true) {
            kVar = this.A;
            float[] fArr = kVar.f6230e;
            if (i >= fArr.length) {
                break;
            }
            float fAbs = Math.abs(f - fArr[i]);
            if (fAbs < f4) {
                i10 = i;
                f4 = fAbs;
            }
            i++;
        }
        kVar.f = i10;
        String str = kVar.f6229d[i10];
        n nVar = this.f6288z;
        ((String[]) nVar.f)[0] = str;
        k(this.T, nVar.g(1) || nVar.g(0));
    }

    public final void o() {
        long jS;
        long jG0;
        if (i() && this.E0) {
            p1.w0 w0Var = this.B0;
            if (w0Var == null || !w0Var.e0(16)) {
                jS = 0;
                jG0 = 0;
            } else {
                jS = w0Var.s() + this.Q0;
                jG0 = w0Var.G0() + this.Q0;
            }
            TextView textView = this.f6259a0;
            if (textView != null && !this.I0) {
                textView.setText(s1.b0.C(this.f6261c0, this.f6262d0, jS));
            }
            u0 u0Var = this.f6260b0;
            if (u0Var != null) {
                u0Var.setPosition(jS);
                u0Var.setBufferedPosition(jG0);
            }
            a2.a aVar = this.f6265g0;
            removeCallbacks(aVar);
            int I = w0Var == null ? 1 : w0Var.I();
            if (w0Var != null && w0Var.P()) {
                long jMin = Math.min(u0Var != null ? u0Var.getPreferredUpdateDelay() : 1000L, 1000 - (jS % 1000));
                float f = w0Var.h().f10038a;
                postDelayed(aVar, s1.b0.j(f > 0.0f ? (long) (jMin / f) : 1000L, this.K0, 1000L));
            } else {
                if (I == 4 || I == 1) {
                    return;
                }
                postDelayed(aVar, 1000L);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        x xVar = this.f6278u;
        xVar.f6325a.addOnLayoutChangeListener(xVar.f6346x);
        this.E0 = true;
        if (h()) {
            xVar.g();
        }
        j();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        x xVar = this.f6278u;
        xVar.f6325a.removeOnLayoutChangeListener(xVar.f6346x);
        this.E0 = false;
        removeCallbacks(this.f6265g0);
        xVar.f();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z2, int i, int i10, int i11, int i12) {
        super.onLayout(z2, i, i10, i11, i12);
        View view = this.f6278u.f6326b;
        if (view != null) {
            view.layout(0, 0, i11 - i, i12 - i10);
        }
    }

    public final void p() {
        ImageView imageView;
        if (i() && this.E0 && (imageView = this.N) != null) {
            if (this.L0 == 0) {
                k(imageView, false);
                return;
            }
            p1.w0 w0Var = this.B0;
            String str = this.f6269k0;
            Drawable drawable = this.f6266h0;
            if (w0Var == null || !w0Var.e0(15)) {
                k(imageView, false);
                imageView.setImageDrawable(drawable);
                imageView.setContentDescription(str);
                return;
            }
            k(imageView, true);
            int iV0 = w0Var.v0();
            if (iV0 == 0) {
                imageView.setImageDrawable(drawable);
                imageView.setContentDescription(str);
            } else if (iV0 == 1) {
                imageView.setImageDrawable(this.f6267i0);
                imageView.setContentDescription(this.l0);
            } else {
                if (iV0 != 2) {
                    return;
                }
                imageView.setImageDrawable(this.f6268j0);
                imageView.setContentDescription(this.f6270m0);
            }
        }
    }

    public final void q() {
        RecyclerView recyclerView = this.f6286y;
        recyclerView.measure(0, 0);
        int width = getWidth();
        int i = this.F;
        int iMin = Math.min(recyclerView.getMeasuredWidth(), width - (i * 2));
        PopupWindow popupWindow = this.E;
        popupWindow.setWidth(iMin);
        popupWindow.setHeight(Math.min(getHeight() - (i * 2), recyclerView.getMeasuredHeight()));
    }

    public final void r() {
        ImageView imageView;
        if (i() && this.E0 && (imageView = this.O) != null) {
            p1.w0 w0Var = this.B0;
            if (!this.f6278u.b(imageView)) {
                k(imageView, false);
                return;
            }
            String str = this.f6276s0;
            Drawable drawable = this.f6272o0;
            if (w0Var == null || !w0Var.e0(14)) {
                k(imageView, false);
                imageView.setImageDrawable(drawable);
                imageView.setContentDescription(str);
                return;
            }
            k(imageView, true);
            if (w0Var.C0()) {
                drawable = this.f6271n0;
            }
            imageView.setImageDrawable(drawable);
            if (w0Var.C0()) {
                str = this.f6275r0;
            }
            imageView.setContentDescription(str);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:71:0x013e  */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1, types: [int] */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r22v0 */
    /* JADX WARN: Type inference failed for: r22v1 */
    /* JADX WARN: Type inference failed for: r22v2 */
    /* JADX WARN: Type inference failed for: r22v3 */
    /* JADX WARN: Type inference failed for: r22v4 */
    /* JADX WARN: Type inference failed for: r22v5 */
    /* JADX WARN: Type inference failed for: r22v6 */
    /* JADX WARN: Type inference failed for: r22v7 */
    /* JADX WARN: Type inference failed for: r22v8 */
    /* JADX WARN: Type inference failed for: r2v11, types: [p1.f1] */
    /* JADX WARN: Type inference failed for: r2v13, types: [p1.f1] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v34 */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r2v36 */
    /* JADX WARN: Type inference failed for: r4v12, types: [p1.b] */
    /* JADX WARN: Type inference failed for: r7v3, types: [p1.c1] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void s() {
        /*
            Method dump skipped, instruction units count: 414
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i4.s.s():void");
    }

    public void setAnimationEnabled(boolean z2) {
        this.f6278u.C = z2;
    }

    @Deprecated
    public void setOnFullScreenModeChangedListener(i iVar) {
        this.C0 = iVar;
        boolean z2 = iVar != null;
        ImageView imageView = this.R;
        if (imageView != null) {
            if (z2) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
        }
        boolean z10 = iVar != null;
        ImageView imageView2 = this.S;
        if (imageView2 == null) {
            return;
        }
        if (z10) {
            imageView2.setVisibility(0);
        } else {
            imageView2.setVisibility(8);
        }
    }

    public void setPlayer(p1.w0 w0Var) {
        s1.d.g(Looper.myLooper() == Looper.getMainLooper());
        s1.d.b(w0Var == null || w0Var.z0() == Looper.getMainLooper());
        p1.w0 w0Var2 = this.B0;
        if (w0Var2 == w0Var) {
            return;
        }
        h hVar = this.f6282w;
        if (w0Var2 != null) {
            w0Var2.N0(hVar);
        }
        this.B0 = w0Var;
        if (w0Var != null) {
            w0Var.J(hVar);
        }
        j();
    }

    public void setRepeatToggleModes(int i) {
        this.L0 = i;
        p1.w0 w0Var = this.B0;
        if (w0Var != null && w0Var.e0(15)) {
            int iV0 = this.B0.v0();
            if (i == 0 && iV0 != 0) {
                this.B0.i0(0);
            } else if (i == 1 && iV0 == 2) {
                this.B0.i0(1);
            } else if (i == 2 && iV0 == 1) {
                this.B0.i0(2);
            }
        }
        this.f6278u.h(this.N, i != 0);
        p();
    }

    public void setShowFastForwardButton(boolean z2) {
        this.f6278u.h(this.J, z2);
        l();
    }

    @Deprecated
    public void setShowMultiWindowTimeBar(boolean z2) {
        this.F0 = z2;
        s();
    }

    public void setShowNextButton(boolean z2) {
        this.f6278u.h(this.H, z2);
        l();
    }

    public void setShowPlayButtonIfPlaybackIsSuppressed(boolean z2) {
        this.G0 = z2;
        m();
    }

    public void setShowPreviousButton(boolean z2) {
        this.f6278u.h(this.G, z2);
        l();
    }

    public void setShowRewindButton(boolean z2) {
        this.f6278u.h(this.K, z2);
        l();
    }

    public void setShowShuffleButton(boolean z2) {
        this.f6278u.h(this.O, z2);
        r();
    }

    public void setShowSubtitleButton(boolean z2) {
        this.f6278u.h(this.Q, z2);
    }

    public void setShowTimeoutMs(int i) {
        this.J0 = i;
        if (h()) {
            this.f6278u.g();
        }
    }

    public void setShowVrButton(boolean z2) {
        this.f6278u.h(this.P, z2);
    }

    public void setTimeBarMinUpdateInterval(int i) {
        this.K0 = s1.b0.i(i, 16, 1000);
    }

    public void setVrButtonListener(View.OnClickListener onClickListener) {
        View view = this.P;
        if (view != null) {
            view.setOnClickListener(onClickListener);
            k(view, onClickListener != null);
        }
    }

    public final void t() {
        g gVar = this.B;
        gVar.getClass();
        List list = Collections.EMPTY_LIST;
        gVar.f6223d = list;
        g gVar2 = this.C;
        gVar2.getClass();
        gVar2.f6223d = list;
        p1.w0 w0Var = this.B0;
        ImageView imageView = this.Q;
        if (w0Var != null && w0Var.e0(30) && this.B0.e0(29)) {
            n1 n1VarL = this.B0.L();
            aa.c1 c1VarF = f(n1VarL, 1);
            gVar2.f6223d = c1VarF;
            s sVar = gVar2.f6225g;
            p1.w0 w0Var2 = sVar.B0;
            n nVar = sVar.f6288z;
            w0Var2.getClass();
            l1 l1VarE0 = w0Var2.E0();
            if (!c1VarF.isEmpty()) {
                if (gVar2.g(l1VarE0)) {
                    int i = 0;
                    while (true) {
                        if (i >= c1VarF.f652x) {
                            break;
                        }
                        p pVar = (p) c1VarF.get(i);
                        if (pVar.f6244a.f9947e[pVar.f6245b]) {
                            ((String[]) nVar.f)[1] = pVar.f6246c;
                            break;
                        }
                        i++;
                    }
                } else {
                    ((String[]) nVar.f)[1] = sVar.getResources().getString(l0.exo_track_selection_auto);
                }
            } else {
                ((String[]) nVar.f)[1] = sVar.getResources().getString(l0.exo_track_selection_none);
            }
            if (this.f6278u.b(imageView)) {
                gVar.h(f(n1VarL, 3));
            } else {
                gVar.h(aa.c1.f650y);
            }
        }
        k(imageView, gVar.a() > 0);
        n nVar2 = this.f6288z;
        k(this.T, nVar2.g(1) || nVar2.g(0));
    }

    public void setProgressUpdateListener(l lVar) {
    }
}
