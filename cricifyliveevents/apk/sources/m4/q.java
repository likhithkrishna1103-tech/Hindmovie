package m4;

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
import ua.z0;
import v1.c1;
import v1.e1;
import v1.f1;
import v1.l1;
import v1.m1;
import v1.n1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class q extends FrameLayout {
    public static final float[] T0;
    public final l A;
    public final String A0;
    public final i B;
    public final String B0;
    public final e C;
    public v1.w0 C0;
    public final e D;
    public g D0;
    public final m2.e E;
    public boolean E0;
    public final PopupWindow F;
    public boolean F0;
    public final int G;
    public boolean G0;
    public final View H;
    public boolean H0;
    public final View I;
    public boolean I0;
    public final View J;
    public boolean J0;
    public final View K;
    public int K0;
    public final View L;
    public int L0;
    public final TextView M;
    public int M0;
    public final TextView N;
    public long[] N0;
    public final ImageView O;
    public boolean[] O0;
    public final ImageView P;
    public final long[] P0;
    public final View Q;
    public final boolean[] Q0;
    public final ImageView R;
    public long R0;
    public final ImageView S;
    public boolean S0;
    public final ImageView T;
    public final View U;
    public final View V;
    public final View W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public final TextView f8228a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public final TextView f8229b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public final r0 f8230c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public final StringBuilder f8231d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public final Formatter f8232e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public final c1 f8233f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public final e1 f8234g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public final androidx.emoji2.text.w f8235h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public final Drawable f8236i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public final Drawable f8237j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public final Drawable f8238k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public final String f8239l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public final String f8240m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public final String f8241n0;
    public final Drawable o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public final Drawable f8242p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public final float f8243q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public final float f8244r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public final String f8245s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public final String f8246t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public final Drawable f8247u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final v f8248v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public final Drawable f8249v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Resources f8250w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public final String f8251w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final f f8252x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public final String f8253x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final CopyOnWriteArrayList f8254y;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public final Drawable f8255y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final RecyclerView f8256z;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public final Drawable f8257z0;

    static {
        v1.h0.a("media3.ui");
        T0 = new float[]{0.25f, 0.5f, 0.75f, 1.0f, 1.25f, 1.5f, 2.0f};
    }

    public q(Context context, AttributeSet attributeSet) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        boolean z18;
        ImageView imageView;
        f fVar;
        boolean z19;
        boolean z20;
        Typeface typefaceB;
        super(context, null, 0);
        int resourceId = h0.exo_player_control_view;
        this.H0 = true;
        this.K0 = 5000;
        this.M0 = 0;
        this.L0 = 200;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, l0.PlayerControlView, 0, 0);
            try {
                resourceId = typedArrayObtainStyledAttributes.getResourceId(l0.PlayerControlView_controller_layout_id, resourceId);
                this.K0 = typedArrayObtainStyledAttributes.getInt(l0.PlayerControlView_show_timeout, this.K0);
                this.M0 = typedArrayObtainStyledAttributes.getInt(l0.PlayerControlView_repeat_toggle_modes, this.M0);
                boolean z21 = typedArrayObtainStyledAttributes.getBoolean(l0.PlayerControlView_show_rewind_button, true);
                boolean z22 = typedArrayObtainStyledAttributes.getBoolean(l0.PlayerControlView_show_fastforward_button, true);
                boolean z23 = typedArrayObtainStyledAttributes.getBoolean(l0.PlayerControlView_show_previous_button, true);
                boolean z24 = typedArrayObtainStyledAttributes.getBoolean(l0.PlayerControlView_show_next_button, true);
                boolean z25 = typedArrayObtainStyledAttributes.getBoolean(l0.PlayerControlView_show_shuffle_button, false);
                boolean z26 = typedArrayObtainStyledAttributes.getBoolean(l0.PlayerControlView_show_subtitle_button, false);
                boolean z27 = typedArrayObtainStyledAttributes.getBoolean(l0.PlayerControlView_show_vr_button, false);
                setTimeBarMinUpdateInterval(typedArrayObtainStyledAttributes.getInt(l0.PlayerControlView_time_bar_min_update_interval, this.L0));
                boolean z28 = typedArrayObtainStyledAttributes.getBoolean(l0.PlayerControlView_animation_enabled, true);
                typedArrayObtainStyledAttributes.recycle();
                z17 = z28;
                z10 = z25;
                z13 = z21;
                z14 = z22;
                z11 = z26;
                z12 = z27;
                z15 = z23;
                z16 = z24;
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes.recycle();
                throw th;
            }
        } else {
            z10 = false;
            z11 = false;
            z12 = false;
            z13 = true;
            z14 = true;
            z15 = true;
            z16 = true;
            z17 = true;
        }
        LayoutInflater.from(context).inflate(resourceId, this);
        setDescendantFocusability(262144);
        f fVar2 = new f(this);
        this.f8252x = fVar2;
        this.f8254y = new CopyOnWriteArrayList();
        this.f8233f0 = new c1();
        this.f8234g0 = new e1();
        StringBuilder sb = new StringBuilder();
        this.f8231d0 = sb;
        this.f8232e0 = new Formatter(sb, Locale.getDefault());
        this.N0 = new long[0];
        this.O0 = new boolean[0];
        this.P0 = new long[0];
        this.Q0 = new boolean[0];
        this.f8235h0 = new androidx.emoji2.text.w(25, this);
        this.f8228a0 = (TextView) findViewById(f0.exo_duration);
        this.f8229b0 = (TextView) findViewById(f0.exo_position);
        ImageView imageView2 = (ImageView) findViewById(f0.exo_subtitle);
        this.R = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(fVar2);
        }
        ImageView imageView3 = (ImageView) findViewById(f0.exo_fullscreen);
        this.S = imageView3;
        com.google.android.material.datepicker.n nVar = new com.google.android.material.datepicker.n(1, this);
        if (imageView3 != null) {
            imageView3.setVisibility(8);
            imageView3.setOnClickListener(nVar);
        }
        ImageView imageView4 = (ImageView) findViewById(f0.exo_minimal_fullscreen);
        this.T = imageView4;
        com.google.android.material.datepicker.n nVar2 = new com.google.android.material.datepicker.n(1, this);
        if (imageView4 != null) {
            imageView4.setVisibility(8);
            imageView4.setOnClickListener(nVar2);
        }
        View viewFindViewById = findViewById(f0.exo_settings);
        this.U = viewFindViewById;
        if (viewFindViewById != null) {
            viewFindViewById.setOnClickListener(fVar2);
        }
        View viewFindViewById2 = findViewById(f0.exo_playback_speed);
        this.V = viewFindViewById2;
        if (viewFindViewById2 != null) {
            viewFindViewById2.setOnClickListener(fVar2);
        }
        View viewFindViewById3 = findViewById(f0.exo_audio_track);
        this.W = viewFindViewById3;
        if (viewFindViewById3 != null) {
            viewFindViewById3.setOnClickListener(fVar2);
        }
        r0 r0Var = (r0) findViewById(f0.exo_progress);
        View viewFindViewById4 = findViewById(f0.exo_progress_placeholder);
        if (r0Var != null) {
            this.f8230c0 = r0Var;
            z18 = z10;
        } else if (viewFindViewById4 != null) {
            z18 = z10;
            DefaultTimeBar defaultTimeBar = new DefaultTimeBar(context, null, attributeSet, k0.ExoStyledControls_TimeBar);
            defaultTimeBar.setId(f0.exo_progress);
            defaultTimeBar.setLayoutParams(viewFindViewById4.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) viewFindViewById4.getParent();
            int iIndexOfChild = viewGroup.indexOfChild(viewFindViewById4);
            viewGroup.removeView(viewFindViewById4);
            viewGroup.addView(defaultTimeBar, iIndexOfChild);
            this.f8230c0 = defaultTimeBar;
        } else {
            z18 = z10;
            this.f8230c0 = null;
        }
        r0 r0Var2 = this.f8230c0;
        if (r0Var2 != null) {
            ((DefaultTimeBar) r0Var2).S.add(fVar2);
        }
        View viewFindViewById5 = findViewById(f0.exo_play_pause);
        this.J = viewFindViewById5;
        if (viewFindViewById5 != null) {
            viewFindViewById5.setOnClickListener(fVar2);
        }
        View viewFindViewById6 = findViewById(f0.exo_prev);
        this.H = viewFindViewById6;
        if (viewFindViewById6 != null) {
            viewFindViewById6.setOnClickListener(fVar2);
        }
        View viewFindViewById7 = findViewById(f0.exo_next);
        this.I = viewFindViewById7;
        if (viewFindViewById7 != null) {
            viewFindViewById7.setOnClickListener(fVar2);
        }
        int i = e0.roboto_medium_numbers;
        ThreadLocal threadLocal = k0.k.f6774a;
        if (context.isRestricted()) {
            z19 = z11;
            z20 = z12;
            imageView = imageView2;
            fVar = fVar2;
            typefaceB = null;
        } else {
            imageView = imageView2;
            fVar = fVar2;
            z19 = z11;
            z20 = z12;
            typefaceB = k0.k.b(context, i, new TypedValue(), 0, null, false, false);
        }
        View viewFindViewById8 = findViewById(f0.exo_rew);
        TextView textView = viewFindViewById8 == null ? (TextView) findViewById(f0.exo_rew_with_amount) : null;
        this.N = textView;
        if (textView != null) {
            textView.setTypeface(typefaceB);
        }
        viewFindViewById8 = viewFindViewById8 == null ? textView : viewFindViewById8;
        this.L = viewFindViewById8;
        if (viewFindViewById8 != null) {
            viewFindViewById8.setOnClickListener(fVar);
        }
        View viewFindViewById9 = findViewById(f0.exo_ffwd);
        TextView textView2 = viewFindViewById9 == null ? (TextView) findViewById(f0.exo_ffwd_with_amount) : null;
        this.M = textView2;
        if (textView2 != null) {
            textView2.setTypeface(typefaceB);
        }
        viewFindViewById9 = viewFindViewById9 == null ? textView2 : viewFindViewById9;
        this.K = viewFindViewById9;
        if (viewFindViewById9 != null) {
            viewFindViewById9.setOnClickListener(fVar);
        }
        ImageView imageView5 = (ImageView) findViewById(f0.exo_repeat_toggle);
        this.O = imageView5;
        if (imageView5 != null) {
            imageView5.setOnClickListener(fVar);
        }
        ImageView imageView6 = (ImageView) findViewById(f0.exo_shuffle);
        this.P = imageView6;
        if (imageView6 != null) {
            imageView6.setOnClickListener(fVar);
        }
        Resources resources = context.getResources();
        this.f8250w = resources;
        this.f8243q0 = resources.getInteger(g0.exo_media_button_opacity_percentage_enabled) / 100.0f;
        this.f8244r0 = resources.getInteger(g0.exo_media_button_opacity_percentage_disabled) / 100.0f;
        View viewFindViewById10 = findViewById(f0.exo_vr);
        this.Q = viewFindViewById10;
        if (viewFindViewById10 != null) {
            k(viewFindViewById10, false);
        }
        v vVar = new v(this);
        this.f8248v = vVar;
        vVar.C = z17;
        l lVar = new l(this, new String[]{resources.getString(j0.exo_controls_playback_speed), resources.getString(j0.exo_track_selection_title_audio)}, new Drawable[]{resources.getDrawable(d0.exo_styled_controls_speed, context.getTheme()), resources.getDrawable(d0.exo_styled_controls_audiotrack, context.getTheme())});
        this.A = lVar;
        this.G = resources.getDimensionPixelSize(c0.exo_settings_offset);
        RecyclerView recyclerView = (RecyclerView) LayoutInflater.from(context).inflate(h0.exo_styled_settings_list, (ViewGroup) null);
        this.f8256z = recyclerView;
        recyclerView.setAdapter(lVar);
        getContext();
        recyclerView.setLayoutManager(new LinearLayoutManager(1));
        PopupWindow popupWindow = new PopupWindow((View) recyclerView, -2, -2, true);
        this.F = popupWindow;
        if (y1.a0.f14551a < 23) {
            popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        }
        popupWindow.setOnDismissListener(fVar);
        this.S0 = true;
        this.E = new m2.e(getResources());
        this.f8247u0 = resources.getDrawable(d0.exo_styled_controls_subtitle_on, context.getTheme());
        this.f8249v0 = resources.getDrawable(d0.exo_styled_controls_subtitle_off, context.getTheme());
        this.f8251w0 = resources.getString(j0.exo_controls_cc_enabled_description);
        this.f8253x0 = resources.getString(j0.exo_controls_cc_disabled_description);
        this.C = new e(this, 1);
        this.D = new e(this, 0);
        this.B = new i(this, resources.getStringArray(a0.exo_controls_playback_speeds), T0);
        this.f8255y0 = resources.getDrawable(d0.exo_styled_controls_fullscreen_exit, context.getTheme());
        this.f8257z0 = resources.getDrawable(d0.exo_styled_controls_fullscreen_enter, context.getTheme());
        this.f8236i0 = resources.getDrawable(d0.exo_styled_controls_repeat_off, context.getTheme());
        this.f8237j0 = resources.getDrawable(d0.exo_styled_controls_repeat_one, context.getTheme());
        this.f8238k0 = resources.getDrawable(d0.exo_styled_controls_repeat_all, context.getTheme());
        this.o0 = resources.getDrawable(d0.exo_styled_controls_shuffle_on, context.getTheme());
        this.f8242p0 = resources.getDrawable(d0.exo_styled_controls_shuffle_off, context.getTheme());
        this.A0 = resources.getString(j0.exo_controls_fullscreen_exit_description);
        this.B0 = resources.getString(j0.exo_controls_fullscreen_enter_description);
        this.f8239l0 = resources.getString(j0.exo_controls_repeat_off_description);
        this.f8240m0 = resources.getString(j0.exo_controls_repeat_one_description);
        this.f8241n0 = resources.getString(j0.exo_controls_repeat_all_description);
        this.f8245s0 = resources.getString(j0.exo_controls_shuffle_on_description);
        this.f8246t0 = resources.getString(j0.exo_controls_shuffle_off_description);
        vVar.h((ViewGroup) findViewById(f0.exo_bottom_bar), true);
        vVar.h(viewFindViewById9, z14);
        vVar.h(viewFindViewById8, z13);
        vVar.h(viewFindViewById6, z15);
        vVar.h(viewFindViewById7, z16);
        vVar.h(imageView6, z18);
        vVar.h(imageView, z19);
        vVar.h(viewFindViewById10, z20);
        vVar.h(imageView5, this.M0 != 0);
        addOnLayoutChangeListener(new d(0, this));
    }

    public static void a(q qVar) {
        String str = qVar.B0;
        Drawable drawable = qVar.f8257z0;
        String str2 = qVar.A0;
        Drawable drawable2 = qVar.f8255y0;
        if (qVar.D0 == null) {
            return;
        }
        boolean z10 = qVar.E0;
        qVar.E0 = !z10;
        ImageView imageView = qVar.S;
        if (imageView != null) {
            if (z10) {
                imageView.setImageDrawable(drawable);
                imageView.setContentDescription(str);
            } else {
                imageView.setImageDrawable(drawable2);
                imageView.setContentDescription(str2);
            }
        }
        ImageView imageView2 = qVar.T;
        boolean z11 = qVar.E0;
        if (imageView2 == null) {
            return;
        }
        if (z11) {
            imageView2.setImageDrawable(drawable2);
            imageView2.setContentDescription(str2);
        } else {
            imageView2.setImageDrawable(drawable);
            imageView2.setContentDescription(str);
        }
    }

    public static boolean c(v1.w0 w0Var, e1 e1Var) {
        f1 f1VarV0;
        int iO;
        if (!w0Var.Z(17) || (iO = (f1VarV0 = w0Var.v0()).o()) <= 1 || iO > 100) {
            return false;
        }
        for (int i = 0; i < iO; i++) {
            if (f1VarV0.m(i, e1Var, 0L).f12653m == -9223372036854775807L) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlaybackSpeed(float f) {
        v1.w0 w0Var = this.C0;
        if (w0Var == null || !w0Var.Z(13)) {
            return;
        }
        v1.w0 w0Var2 = this.C0;
        w0Var2.f(new v1.q0(f, w0Var2.d().f12969b));
    }

    public final boolean d(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        v1.w0 w0Var = this.C0;
        if (w0Var == null) {
            return false;
        }
        if (keyCode != 90 && keyCode != 89 && keyCode != 85 && keyCode != 79 && keyCode != 126 && keyCode != 127 && keyCode != 87 && keyCode != 88) {
            return false;
        }
        if (keyEvent.getAction() == 0) {
            if (keyCode == 90) {
                if (w0Var.E() != 4 && w0Var.Z(12)) {
                    w0Var.K0();
                }
            } else if (keyCode == 89 && w0Var.Z(11)) {
                w0Var.M0();
            } else if (keyEvent.getRepeatCount() == 0) {
                if (keyCode == 79 || keyCode == 85) {
                    if (y1.a0.Y(w0Var, this.H0)) {
                        y1.a0.F(w0Var);
                    } else if (w0Var.Z(1)) {
                        w0Var.c();
                    }
                } else if (keyCode != 87) {
                    if (keyCode != 88) {
                        if (keyCode == 126) {
                            y1.a0.F(w0Var);
                        } else if (keyCode == 127) {
                            int i = y1.a0.f14551a;
                            if (w0Var.Z(1)) {
                                w0Var.c();
                            }
                        }
                    } else if (w0Var.Z(7)) {
                        w0Var.R0();
                    }
                } else if (w0Var.Z(9)) {
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

    public final void e(v4.z zVar, View view) {
        this.f8256z.setAdapter(zVar);
        q();
        this.S0 = false;
        PopupWindow popupWindow = this.F;
        popupWindow.dismiss();
        this.S0 = true;
        int width = getWidth() - popupWindow.getWidth();
        int i = this.G;
        popupWindow.showAsDropDown(view, width - i, (-popupWindow.getHeight()) - i);
    }

    public final z0 f(n1 n1Var, int i) {
        ua.q.d(4, "initialCapacity");
        Object[] objArrCopyOf = new Object[4];
        ua.i0 i0Var = n1Var.f12882a;
        int i10 = 0;
        for (int i11 = 0; i11 < i0Var.size(); i11++) {
            m1 m1Var = (m1) i0Var.get(i11);
            if (m1Var.f12873b.f12704c == i) {
                for (int i12 = 0; i12 < m1Var.f12872a; i12++) {
                    if (m1Var.f12875d[i12] == 4) {
                        v1.p pVar = m1Var.f12873b.f12705d[i12];
                        if ((pVar.f12939e & 2) == 0) {
                            n nVar = new n(n1Var, i11, i12, this.E.t(pVar));
                            int i13 = i10 + 1;
                            int iF = ua.c0.f(objArrCopyOf.length, i13);
                            if (iF > objArrCopyOf.length) {
                                objArrCopyOf = Arrays.copyOf(objArrCopyOf, iF);
                            }
                            objArrCopyOf[i10] = nVar;
                            i10 = i13;
                        }
                    }
                }
            }
        }
        return ua.i0.i(i10, objArrCopyOf);
    }

    public final void g() {
        v vVar = this.f8248v;
        int i = vVar.f8292z;
        if (i == 3 || i == 2) {
            return;
        }
        vVar.f();
        if (!vVar.C) {
            vVar.i(2);
        } else if (vVar.f8292z == 1) {
            vVar.f8279m.start();
        } else {
            vVar.f8280n.start();
        }
    }

    public v1.w0 getPlayer() {
        return this.C0;
    }

    public int getRepeatToggleModes() {
        return this.M0;
    }

    public boolean getShowShuffleButton() {
        return this.f8248v.b(this.P);
    }

    public boolean getShowSubtitleButton() {
        return this.f8248v.b(this.R);
    }

    public int getShowTimeoutMs() {
        return this.K0;
    }

    public boolean getShowVrButton() {
        return this.f8248v.b(this.Q);
    }

    public final boolean h() {
        v vVar = this.f8248v;
        return vVar.f8292z == 0 && vVar.f8269a.i();
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

    public final void k(View view, boolean z10) {
        if (view == null) {
            return;
        }
        view.setEnabled(z10);
        view.setAlpha(z10 ? this.f8243q0 : this.f8244r0);
    }

    public final void l() {
        boolean Z;
        boolean Z2;
        boolean Z3;
        boolean Z4;
        boolean Z5;
        if (i() && this.F0) {
            v1.w0 w0Var = this.C0;
            if (w0Var != null) {
                Z2 = (this.G0 && c(w0Var, this.f8234g0)) ? w0Var.Z(10) : w0Var.Z(5);
                Z3 = w0Var.Z(7);
                Z4 = w0Var.Z(11);
                Z5 = w0Var.Z(12);
                Z = w0Var.Z(9);
            } else {
                Z = false;
                Z2 = false;
                Z3 = false;
                Z4 = false;
                Z5 = false;
            }
            Resources resources = this.f8250w;
            View view = this.L;
            if (Z4) {
                v1.w0 w0Var2 = this.C0;
                int iW0 = (int) ((w0Var2 != null ? w0Var2.W0() : 5000L) / 1000);
                TextView textView = this.N;
                if (textView != null) {
                    textView.setText(String.valueOf(iW0));
                }
                if (view != null) {
                    view.setContentDescription(resources.getQuantityString(i0.exo_controls_rewind_by_amount_description, iW0, Integer.valueOf(iW0)));
                }
            }
            View view2 = this.K;
            if (Z5) {
                v1.w0 w0Var3 = this.C0;
                int iO = (int) ((w0Var3 != null ? w0Var3.o() : 15000L) / 1000);
                TextView textView2 = this.M;
                if (textView2 != null) {
                    textView2.setText(String.valueOf(iO));
                }
                if (view2 != null) {
                    view2.setContentDescription(resources.getQuantityString(i0.exo_controls_fastforward_by_amount_description, iO, Integer.valueOf(iO)));
                }
            }
            k(this.H, Z3);
            k(view, Z4);
            k(view2, Z5);
            k(this.I, Z);
            r0 r0Var = this.f8230c0;
            if (r0Var != null) {
                r0Var.setEnabled(Z2);
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
            boolean r0 = r6.F0
            if (r0 != 0) goto Lb
            goto L66
        Lb:
            android.view.View r0 = r6.J
            if (r0 == 0) goto L66
            v1.w0 r1 = r6.C0
            boolean r2 = r6.H0
            boolean r1 = y1.a0.Y(r1, r2)
            if (r1 == 0) goto L1c
            int r2 = m4.d0.exo_styled_controls_play
            goto L1e
        L1c:
            int r2 = m4.d0.exo_styled_controls_pause
        L1e:
            if (r1 == 0) goto L23
            int r1 = m4.j0.exo_controls_play_description
            goto L25
        L23:
            int r1 = m4.j0.exo_controls_pause_description
        L25:
            r3 = r0
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            android.content.Context r4 = r6.getContext()
            android.content.res.Resources$Theme r4 = r4.getTheme()
            android.content.res.Resources r5 = r6.f8250w
            android.graphics.drawable.Drawable r2 = r5.getDrawable(r2, r4)
            r3.setImageDrawable(r2)
            java.lang.String r1 = r5.getString(r1)
            r0.setContentDescription(r1)
            v1.w0 r1 = r6.C0
            if (r1 == 0) goto L62
            r2 = 1
            boolean r1 = r1.Z(r2)
            if (r1 == 0) goto L62
            v1.w0 r1 = r6.C0
            r3 = 17
            boolean r1 = r1.Z(r3)
            if (r1 == 0) goto L63
            v1.w0 r1 = r6.C0
            v1.f1 r1 = r1.v0()
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
        throw new UnsupportedOperationException("Method not decompiled: m4.q.m():void");
    }

    public final void n() {
        i iVar;
        v1.w0 w0Var = this.C0;
        if (w0Var == null) {
            return;
        }
        float f = w0Var.d().f12968a;
        float f10 = Float.MAX_VALUE;
        int i = 0;
        int i10 = 0;
        while (true) {
            iVar = this.B;
            float[] fArr = iVar.f8177e;
            if (i >= fArr.length) {
                break;
            }
            float fAbs = Math.abs(f - fArr[i]);
            if (fAbs < f10) {
                i10 = i;
                f10 = fAbs;
            }
            i++;
        }
        iVar.f = i10;
        String str = iVar.f8176d[i10];
        l lVar = this.A;
        ((String[]) lVar.f)[0] = str;
        k(this.U, lVar.h(1) || lVar.h(0));
    }

    public final void o() {
        long jQ;
        long jG0;
        if (i() && this.F0) {
            v1.w0 w0Var = this.C0;
            if (w0Var == null || !w0Var.Z(16)) {
                jQ = 0;
                jG0 = 0;
            } else {
                jQ = w0Var.q() + this.R0;
                jG0 = w0Var.G0() + this.R0;
            }
            TextView textView = this.f8229b0;
            if (textView != null && !this.J0) {
                textView.setText(y1.a0.C(this.f8231d0, this.f8232e0, jQ));
            }
            r0 r0Var = this.f8230c0;
            if (r0Var != null) {
                r0Var.setPosition(jQ);
                r0Var.setBufferedPosition(jG0);
            }
            androidx.emoji2.text.w wVar = this.f8235h0;
            removeCallbacks(wVar);
            int iE = w0Var == null ? 1 : w0Var.E();
            if (w0Var != null && w0Var.M()) {
                long jMin = Math.min(r0Var != null ? r0Var.getPreferredUpdateDelay() : 1000L, 1000 - (jQ % 1000));
                float f = w0Var.d().f12968a;
                postDelayed(wVar, y1.a0.j(f > 0.0f ? (long) (jMin / f) : 1000L, this.L0, 1000L));
            } else {
                if (iE == 4 || iE == 1) {
                    return;
                }
                postDelayed(wVar, 1000L);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        v vVar = this.f8248v;
        vVar.f8269a.addOnLayoutChangeListener(vVar.f8290x);
        this.F0 = true;
        if (h()) {
            vVar.g();
        }
        j();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        v vVar = this.f8248v;
        vVar.f8269a.removeOnLayoutChangeListener(vVar.f8290x);
        this.F0 = false;
        removeCallbacks(this.f8235h0);
        vVar.f();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i, int i10, int i11, int i12) {
        super.onLayout(z10, i, i10, i11, i12);
        View view = this.f8248v.f8270b;
        if (view != null) {
            view.layout(0, 0, i11 - i, i12 - i10);
        }
    }

    public final void p() {
        ImageView imageView;
        if (i() && this.F0 && (imageView = this.O) != null) {
            if (this.M0 == 0) {
                k(imageView, false);
                return;
            }
            v1.w0 w0Var = this.C0;
            String str = this.f8239l0;
            Drawable drawable = this.f8236i0;
            if (w0Var == null || !w0Var.Z(15)) {
                k(imageView, false);
                imageView.setImageDrawable(drawable);
                imageView.setContentDescription(str);
                return;
            }
            k(imageView, true);
            int iU0 = w0Var.u0();
            if (iU0 == 0) {
                imageView.setImageDrawable(drawable);
                imageView.setContentDescription(str);
            } else if (iU0 == 1) {
                imageView.setImageDrawable(this.f8237j0);
                imageView.setContentDescription(this.f8240m0);
            } else {
                if (iU0 != 2) {
                    return;
                }
                imageView.setImageDrawable(this.f8238k0);
                imageView.setContentDescription(this.f8241n0);
            }
        }
    }

    public final void q() {
        RecyclerView recyclerView = this.f8256z;
        recyclerView.measure(0, 0);
        int width = getWidth();
        int i = this.G;
        int iMin = Math.min(recyclerView.getMeasuredWidth(), width - (i * 2));
        PopupWindow popupWindow = this.F;
        popupWindow.setWidth(iMin);
        popupWindow.setHeight(Math.min(getHeight() - (i * 2), recyclerView.getMeasuredHeight()));
    }

    public final void r() {
        ImageView imageView;
        if (i() && this.F0 && (imageView = this.P) != null) {
            v1.w0 w0Var = this.C0;
            if (!this.f8248v.b(imageView)) {
                k(imageView, false);
                return;
            }
            String str = this.f8246t0;
            Drawable drawable = this.f8242p0;
            if (w0Var == null || !w0Var.Z(14)) {
                k(imageView, false);
                imageView.setImageDrawable(drawable);
                imageView.setContentDescription(str);
                return;
            }
            k(imageView, true);
            if (w0Var.C0()) {
                drawable = this.o0;
            }
            imageView.setImageDrawable(drawable);
            if (w0Var.C0()) {
                str = this.f8245s0;
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
    /* JADX WARN: Type inference failed for: r2v11, types: [v1.f1] */
    /* JADX WARN: Type inference failed for: r2v13, types: [v1.f1] */
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
    /* JADX WARN: Type inference failed for: r4v12, types: [v1.b] */
    /* JADX WARN: Type inference failed for: r7v3, types: [v1.c1] */
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
        throw new UnsupportedOperationException("Method not decompiled: m4.q.s():void");
    }

    public void setAnimationEnabled(boolean z10) {
        this.f8248v.C = z10;
    }

    @Deprecated
    public void setOnFullScreenModeChangedListener(g gVar) {
        this.D0 = gVar;
        boolean z10 = gVar != null;
        ImageView imageView = this.S;
        if (imageView != null) {
            if (z10) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
        }
        boolean z11 = gVar != null;
        ImageView imageView2 = this.T;
        if (imageView2 == null) {
            return;
        }
        if (z11) {
            imageView2.setVisibility(0);
        } else {
            imageView2.setVisibility(8);
        }
    }

    public void setPlayer(v1.w0 w0Var) {
        y1.d.g(Looper.myLooper() == Looper.getMainLooper());
        y1.d.b(w0Var == null || w0Var.y0() == Looper.getMainLooper());
        v1.w0 w0Var2 = this.C0;
        if (w0Var2 == w0Var) {
            return;
        }
        f fVar = this.f8252x;
        if (w0Var2 != null) {
            w0Var2.m0(fVar);
        }
        this.C0 = w0Var;
        if (w0Var != null) {
            w0Var.T0(fVar);
        }
        j();
    }

    public void setRepeatToggleModes(int i) {
        this.M0 = i;
        v1.w0 w0Var = this.C0;
        if (w0Var != null && w0Var.Z(15)) {
            int iU0 = this.C0.u0();
            if (i == 0 && iU0 != 0) {
                this.C0.g0(0);
            } else if (i == 1 && iU0 == 2) {
                this.C0.g0(1);
            } else if (i == 2 && iU0 == 1) {
                this.C0.g0(2);
            }
        }
        this.f8248v.h(this.O, i != 0);
        p();
    }

    public void setShowFastForwardButton(boolean z10) {
        this.f8248v.h(this.K, z10);
        l();
    }

    @Deprecated
    public void setShowMultiWindowTimeBar(boolean z10) {
        this.G0 = z10;
        s();
    }

    public void setShowNextButton(boolean z10) {
        this.f8248v.h(this.I, z10);
        l();
    }

    public void setShowPlayButtonIfPlaybackIsSuppressed(boolean z10) {
        this.H0 = z10;
        m();
    }

    public void setShowPreviousButton(boolean z10) {
        this.f8248v.h(this.H, z10);
        l();
    }

    public void setShowRewindButton(boolean z10) {
        this.f8248v.h(this.L, z10);
        l();
    }

    public void setShowShuffleButton(boolean z10) {
        this.f8248v.h(this.P, z10);
        r();
    }

    public void setShowSubtitleButton(boolean z10) {
        this.f8248v.h(this.R, z10);
    }

    public void setShowTimeoutMs(int i) {
        this.K0 = i;
        if (h()) {
            this.f8248v.g();
        }
    }

    public void setShowVrButton(boolean z10) {
        this.f8248v.h(this.Q, z10);
    }

    public void setTimeBarMinUpdateInterval(int i) {
        this.L0 = y1.a0.i(i, 16, 1000);
    }

    public void setVrButtonListener(View.OnClickListener onClickListener) {
        View view = this.Q;
        if (view != null) {
            view.setOnClickListener(onClickListener);
            k(view, onClickListener != null);
        }
    }

    public final void t() {
        e eVar = this.C;
        eVar.getClass();
        List list = Collections.EMPTY_LIST;
        eVar.f8170d = list;
        e eVar2 = this.D;
        eVar2.getClass();
        eVar2.f8170d = list;
        v1.w0 w0Var = this.C0;
        ImageView imageView = this.R;
        if (w0Var != null && w0Var.Z(30) && this.C0.Z(29)) {
            n1 n1VarG = this.C0.G();
            z0 z0VarF = f(n1VarG, 1);
            eVar2.f8170d = z0VarF;
            q qVar = eVar2.f8172g;
            v1.w0 w0Var2 = qVar.C0;
            l lVar = qVar.A;
            w0Var2.getClass();
            l1 l1VarE0 = w0Var2.E0();
            if (!z0VarF.isEmpty()) {
                if (eVar2.h(l1VarE0)) {
                    int i = 0;
                    while (true) {
                        if (i >= z0VarF.f12415y) {
                            break;
                        }
                        n nVar = (n) z0VarF.get(i);
                        if (nVar.f8194a.f12876e[nVar.f8195b]) {
                            ((String[]) lVar.f)[1] = nVar.f8196c;
                            break;
                        }
                        i++;
                    }
                } else {
                    ((String[]) lVar.f)[1] = qVar.getResources().getString(j0.exo_track_selection_auto);
                }
            } else {
                ((String[]) lVar.f)[1] = qVar.getResources().getString(j0.exo_track_selection_none);
            }
            if (this.f8248v.b(imageView)) {
                eVar.i(f(n1VarG, 3));
            } else {
                eVar.i(z0.f12413z);
            }
        }
        k(imageView, eVar.a() > 0);
        l lVar2 = this.A;
        k(this.U, lVar2.h(1) || lVar2.h(0));
    }

    public void setProgressUpdateListener(j jVar) {
    }
}
