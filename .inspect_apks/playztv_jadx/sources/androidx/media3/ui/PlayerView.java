package androidx.media3.ui;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import i4.a;
import i4.a0;
import i4.d0;
import i4.f0;
import i4.h0;
import i4.i;
import i4.j0;
import i4.l0;
import i4.n0;
import i4.r;
import i4.s;
import i4.x;
import i4.y;
import i4.z;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import p1.n;
import p1.r0;
import p1.r1;
import p1.w0;
import s1.b0;
import s1.d;
import v2.k;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class PlayerView extends FrameLayout {
    public static final /* synthetic */ int T = 0;
    public final SubtitleView A;
    public final View B;
    public final TextView C;
    public final s D;
    public final FrameLayout E;
    public final FrameLayout F;
    public w0 G;
    public boolean H;
    public a0 I;
    public r J;
    public int K;
    public Drawable L;
    public int M;
    public boolean N;
    public CharSequence O;
    public int P;
    public boolean Q;
    public boolean R;
    public boolean S;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final z f1611u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final AspectRatioFrameLayout f1612v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final View f1613w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final View f1614x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final boolean f1615y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final ImageView f1616z;

    /* JADX WARN: Multi-variable type inference failed */
    public PlayerView(Context context, AttributeSet attributeSet) {
        int i;
        int i10;
        boolean z2;
        boolean z10;
        boolean z11;
        int i11;
        int i12;
        int i13;
        int i14;
        boolean z12;
        int i15;
        boolean z13;
        boolean z14;
        int i16;
        boolean z15;
        super(context, attributeSet, 0);
        z zVar = new z(this);
        this.f1611u = zVar;
        if (isInEditMode()) {
            this.f1612v = null;
            this.f1613w = null;
            this.f1614x = null;
            this.f1615y = false;
            this.f1616z = null;
            this.A = null;
            this.B = null;
            this.C = null;
            this.D = null;
            this.E = null;
            this.F = null;
            ImageView imageView = new ImageView(context);
            if (b0.f11647a >= 23) {
                Resources resources = getResources();
                imageView.setImageDrawable(resources.getDrawable(f0.exo_edit_mode_logo, context.getTheme()));
                imageView.setBackgroundColor(resources.getColor(d0.exo_edit_mode_background_color, null));
            } else {
                Resources resources2 = getResources();
                imageView.setImageDrawable(resources2.getDrawable(f0.exo_edit_mode_logo, context.getTheme()));
                imageView.setBackgroundColor(resources2.getColor(d0.exo_edit_mode_background_color));
            }
            addView(imageView);
            return;
        }
        int i17 = j0.exo_player_view;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, n0.PlayerView, 0, 0);
            try {
                boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(n0.PlayerView_shutter_background_color);
                int color = typedArrayObtainStyledAttributes.getColor(n0.PlayerView_shutter_background_color, 0);
                int resourceId = typedArrayObtainStyledAttributes.getResourceId(n0.PlayerView_player_layout_id, i17);
                boolean z16 = typedArrayObtainStyledAttributes.getBoolean(n0.PlayerView_use_artwork, true);
                int i18 = typedArrayObtainStyledAttributes.getInt(n0.PlayerView_artwork_display_mode, 1);
                int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(n0.PlayerView_default_artwork, 0);
                boolean z17 = typedArrayObtainStyledAttributes.getBoolean(n0.PlayerView_use_controller, true);
                int i19 = typedArrayObtainStyledAttributes.getInt(n0.PlayerView_surface_type, 1);
                int i20 = typedArrayObtainStyledAttributes.getInt(n0.PlayerView_resize_mode, 0);
                int i21 = typedArrayObtainStyledAttributes.getInt(n0.PlayerView_show_timeout, 5000);
                boolean z18 = typedArrayObtainStyledAttributes.getBoolean(n0.PlayerView_hide_on_touch, true);
                boolean z19 = typedArrayObtainStyledAttributes.getBoolean(n0.PlayerView_auto_show, true);
                int integer = typedArrayObtainStyledAttributes.getInteger(n0.PlayerView_show_buffering, 0);
                this.N = typedArrayObtainStyledAttributes.getBoolean(n0.PlayerView_keep_content_on_player_reset, this.N);
                boolean z20 = typedArrayObtainStyledAttributes.getBoolean(n0.PlayerView_hide_during_ads, true);
                typedArrayObtainStyledAttributes.recycle();
                i12 = i20;
                z10 = z19;
                z14 = zHasValue;
                i11 = i19;
                i17 = resourceId;
                z2 = z18;
                i = i21;
                z13 = z17;
                z11 = z20;
                i15 = i18;
                i10 = integer;
                i14 = color;
                i13 = resourceId2;
                z12 = z16;
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes.recycle();
                throw th;
            }
        } else {
            i = 5000;
            i10 = 0;
            z2 = true;
            z10 = true;
            z11 = true;
            i11 = 1;
            i12 = 0;
            i13 = 0;
            i14 = 0;
            z12 = true;
            i15 = 1;
            z13 = true;
            z14 = false;
        }
        LayoutInflater.from(context).inflate(i17, this);
        setDescendantFocusability(262144);
        AspectRatioFrameLayout aspectRatioFrameLayout = (AspectRatioFrameLayout) findViewById(h0.exo_content_frame);
        this.f1612v = aspectRatioFrameLayout;
        if (aspectRatioFrameLayout != null) {
            aspectRatioFrameLayout.setResizeMode(i12);
        }
        View viewFindViewById = findViewById(h0.exo_shutter);
        this.f1613w = viewFindViewById;
        if (viewFindViewById != null && z14) {
            viewFindViewById.setBackgroundColor(i14);
        }
        if (aspectRatioFrameLayout == null || i11 == 0) {
            i16 = 0;
            this.f1614x = null;
            z15 = false;
        } else {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            if (i11 == 2) {
                this.f1614x = new TextureView(context);
            } else if (i11 == 3) {
                try {
                    int i22 = k.F;
                    this.f1614x = (View) k.class.getConstructor(Context.class).newInstance(context);
                    z15 = true;
                    this.f1614x.setLayoutParams(layoutParams);
                    this.f1614x.setOnClickListener(zVar);
                    i16 = 0;
                    this.f1614x.setClickable(false);
                    aspectRatioFrameLayout.addView(this.f1614x, 0);
                } catch (Exception e10) {
                    throw new IllegalStateException("spherical_gl_surface_view requires an ExoPlayer dependency", e10);
                }
            } else if (i11 != 4) {
                SurfaceView surfaceView = new SurfaceView(context);
                if (b0.f11647a >= 34) {
                    y.a(surfaceView);
                }
                this.f1614x = surfaceView;
            } else {
                try {
                    int i23 = u2.s.f12650v;
                    this.f1614x = (View) u2.s.class.getConstructor(Context.class).newInstance(context);
                } catch (Exception e11) {
                    throw new IllegalStateException("video_decoder_gl_surface_view requires an ExoPlayer dependency", e11);
                }
            }
            z15 = false;
            this.f1614x.setLayoutParams(layoutParams);
            this.f1614x.setOnClickListener(zVar);
            i16 = 0;
            this.f1614x.setClickable(false);
            aspectRatioFrameLayout.addView(this.f1614x, 0);
        }
        this.f1615y = z15;
        this.E = (FrameLayout) findViewById(h0.exo_ad_overlay);
        this.F = (FrameLayout) findViewById(h0.exo_overlay);
        ImageView imageView2 = (ImageView) findViewById(h0.exo_artwork);
        this.f1616z = imageView2;
        this.K = (!z12 || i15 == 0 || imageView2 == null) ? i16 : i15;
        if (i13 != 0) {
            this.L = getContext().getDrawable(i13);
        }
        SubtitleView subtitleView = (SubtitleView) findViewById(h0.exo_subtitles);
        this.A = subtitleView;
        if (subtitleView != null) {
            subtitleView.a();
            subtitleView.b();
        }
        View viewFindViewById2 = findViewById(h0.exo_buffering);
        this.B = viewFindViewById2;
        if (viewFindViewById2 != null) {
            viewFindViewById2.setVisibility(8);
        }
        this.M = i10;
        TextView textView = (TextView) findViewById(h0.exo_error_message);
        this.C = textView;
        if (textView != null) {
            textView.setVisibility(8);
        }
        s sVar = (s) findViewById(h0.exo_controller);
        View viewFindViewById3 = findViewById(h0.exo_controller_placeholder);
        if (sVar != null) {
            this.D = sVar;
        } else if (viewFindViewById3 != null) {
            s sVar2 = new s(context, attributeSet);
            this.D = sVar2;
            sVar2.setId(h0.exo_controller);
            sVar2.setLayoutParams(viewFindViewById3.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) viewFindViewById3.getParent();
            int iIndexOfChild = viewGroup.indexOfChild(viewFindViewById3);
            viewGroup.removeView(viewFindViewById3);
            viewGroup.addView(sVar2, iIndexOfChild);
        } else {
            this.D = null;
        }
        s sVar3 = this.D;
        this.P = sVar3 != null ? i : i16;
        this.S = z2;
        this.Q = z10;
        this.R = z11;
        this.H = (!z13 || sVar3 == null) ? i16 : 1;
        if (sVar3 != null) {
            x xVar = sVar3.f6278u;
            int i24 = xVar.f6348z;
            if (i24 != 3 && i24 != 2) {
                xVar.f();
                xVar.i(2);
            }
            this.D.f6284x.add(zVar);
        }
        if (z13) {
            setClickable(true);
        }
        l();
    }

    public static void a(TextureView textureView) {
        Matrix matrix = new Matrix();
        textureView.getWidth();
        textureView.getHeight();
        textureView.setTransform(matrix);
    }

    public final void b() {
        s sVar = this.D;
        if (sVar != null) {
            sVar.g();
        }
    }

    public final boolean c() {
        s sVar = this.D;
        return sVar != null && sVar.h();
    }

    public final boolean d() {
        w0 w0Var = this.G;
        return w0Var != null && w0Var.e0(16) && this.G.o() && this.G.C();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        w0 w0Var = this.G;
        if (w0Var != null && w0Var.e0(16) && this.G.o()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        int keyCode = keyEvent.getKeyCode();
        boolean z2 = keyCode == 19 || keyCode == 270 || keyCode == 22 || keyCode == 271 || keyCode == 20 || keyCode == 269 || keyCode == 21 || keyCode == 268 || keyCode == 23;
        s sVar = this.D;
        if (z2 && o() && !sVar.h()) {
            e(true);
            return true;
        }
        if ((o() && sVar.d(keyEvent)) || super.dispatchKeyEvent(keyEvent)) {
            e(true);
            return true;
        }
        if (z2 && o()) {
            e(true);
        }
        return false;
    }

    public final void e(boolean z2) {
        if (!(d() && this.R) && o()) {
            s sVar = this.D;
            boolean z10 = sVar.h() && sVar.getShowTimeoutMs() <= 0;
            boolean zG = g();
            if (z2 || z10 || zG) {
                h(zG);
            }
        }
    }

    public final boolean f(Drawable drawable) {
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > 0 && intrinsicHeight > 0) {
                float width = intrinsicWidth / intrinsicHeight;
                ImageView.ScaleType scaleType = ImageView.ScaleType.FIT_XY;
                if (this.K == 2) {
                    width = getWidth() / getHeight();
                    scaleType = ImageView.ScaleType.CENTER_CROP;
                }
                AspectRatioFrameLayout aspectRatioFrameLayout = this.f1612v;
                if (aspectRatioFrameLayout != null) {
                    aspectRatioFrameLayout.setAspectRatio(width);
                }
                ImageView imageView = this.f1616z;
                imageView.setScaleType(scaleType);
                imageView.setImageDrawable(drawable);
                imageView.setVisibility(0);
                return true;
            }
        }
        return false;
    }

    public final boolean g() {
        w0 w0Var = this.G;
        if (w0Var == null) {
            return true;
        }
        int I = w0Var.I();
        if (!this.Q) {
            return false;
        }
        if (this.G.e0(17) && this.G.w0().p()) {
            return false;
        }
        if (I != 1 && I != 4) {
            w0 w0Var2 = this.G;
            w0Var2.getClass();
            if (w0Var2.C()) {
                return false;
            }
        }
        return true;
    }

    public List<r0> getAdOverlayInfos() {
        ArrayList arrayList = new ArrayList();
        FrameLayout frameLayout = this.F;
        if (frameLayout != null) {
            arrayList.add(new r0(frameLayout));
        }
        s sVar = this.D;
        if (sVar != null) {
            arrayList.add(new r0(sVar));
        }
        return aa.j0.r(arrayList);
    }

    public ViewGroup getAdViewGroup() {
        FrameLayout frameLayout = this.E;
        d.i(frameLayout, "exo_ad_overlay must be present for ad playback");
        return frameLayout;
    }

    public int getArtworkDisplayMode() {
        return this.K;
    }

    public boolean getControllerAutoShow() {
        return this.Q;
    }

    public boolean getControllerHideOnTouch() {
        return this.S;
    }

    public int getControllerShowTimeoutMs() {
        return this.P;
    }

    public Drawable getDefaultArtwork() {
        return this.L;
    }

    public FrameLayout getOverlayFrameLayout() {
        return this.F;
    }

    public w0 getPlayer() {
        return this.G;
    }

    public int getResizeMode() {
        AspectRatioFrameLayout aspectRatioFrameLayout = this.f1612v;
        d.h(aspectRatioFrameLayout);
        return aspectRatioFrameLayout.getResizeMode();
    }

    public SubtitleView getSubtitleView() {
        return this.A;
    }

    @Deprecated
    public boolean getUseArtwork() {
        return this.K != 0;
    }

    public boolean getUseController() {
        return this.H;
    }

    public View getVideoSurfaceView() {
        return this.f1614x;
    }

    public final void h(boolean z2) {
        if (o()) {
            int i = z2 ? 0 : this.P;
            s sVar = this.D;
            sVar.setShowTimeoutMs(i);
            x xVar = sVar.f6278u;
            s sVar2 = xVar.f6325a;
            if (!sVar2.i()) {
                sVar2.setVisibility(0);
                sVar2.j();
                View view = sVar2.I;
                if (view != null) {
                    view.requestFocus();
                }
            }
            xVar.k();
        }
    }

    public final void i() {
        if (!o() || this.G == null) {
            return;
        }
        s sVar = this.D;
        if (!sVar.h()) {
            e(true);
        } else if (this.S) {
            sVar.g();
        }
    }

    public final void j() {
        w0 w0Var = this.G;
        r1 r1VarU = w0Var != null ? w0Var.U() : r1.f10046d;
        int i = r1VarU.f10049a;
        int i10 = r1VarU.f10050b;
        float f = (i10 == 0 || i == 0) ? 0.0f : (i * r1VarU.f10051c) / i10;
        View view = this.f1614x;
        if (view instanceof TextureView) {
            a((TextureView) view);
        }
        float f4 = this.f1615y ? 0.0f : f;
        AspectRatioFrameLayout aspectRatioFrameLayout = this.f1612v;
        if (aspectRatioFrameLayout != null) {
            aspectRatioFrameLayout.setAspectRatio(f4);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k() {
        /*
            r5 = this;
            android.view.View r0 = r5.B
            if (r0 == 0) goto L29
            p1.w0 r1 = r5.G
            r2 = 0
            if (r1 == 0) goto L20
            int r1 = r1.I()
            r3 = 2
            if (r1 != r3) goto L20
            int r1 = r5.M
            r4 = 1
            if (r1 == r3) goto L21
            if (r1 != r4) goto L20
            p1.w0 r1 = r5.G
            boolean r1 = r1.C()
            if (r1 == 0) goto L20
            goto L21
        L20:
            r4 = r2
        L21:
            if (r4 == 0) goto L24
            goto L26
        L24:
            r2 = 8
        L26:
            r0.setVisibility(r2)
        L29:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.ui.PlayerView.k():void");
    }

    public final void l() {
        s sVar = this.D;
        if (sVar == null || !this.H) {
            setContentDescription(null);
        } else if (sVar.h()) {
            setContentDescription(this.S ? getResources().getString(l0.exo_controls_hide) : null);
        } else {
            setContentDescription(getResources().getString(l0.exo_controls_show));
        }
    }

    public final void m() {
        TextView textView = this.C;
        if (textView != null) {
            CharSequence charSequence = this.O;
            if (charSequence != null) {
                textView.setText(charSequence);
                textView.setVisibility(0);
            } else {
                w0 w0Var = this.G;
                if (w0Var != null) {
                    w0Var.k();
                }
                textView.setVisibility(8);
            }
        }
    }

    public final void n(boolean z2) {
        byte[] bArr;
        w0 w0Var = this.G;
        View view = this.f1613w;
        ImageView imageView = this.f1616z;
        boolean zF = false;
        if (w0Var == null || !w0Var.e0(30) || w0Var.L().f9952a.isEmpty()) {
            if (this.N) {
                return;
            }
            if (imageView != null) {
                imageView.setImageResource(R.color.transparent);
                imageView.setVisibility(4);
            }
            if (view != null) {
                view.setVisibility(0);
                return;
            }
            return;
        }
        if (z2 && !this.N && view != null) {
            view.setVisibility(0);
        }
        if (w0Var.L().a(2)) {
            if (imageView != null) {
                imageView.setImageResource(R.color.transparent);
                imageView.setVisibility(4);
                return;
            }
            return;
        }
        if (view != null) {
            view.setVisibility(0);
        }
        if (this.K != 0) {
            d.h(imageView);
            if (w0Var.e0(18) && (bArr = w0Var.P0().f9844k) != null) {
                zF = f(new BitmapDrawable(getResources(), BitmapFactory.decodeByteArray(bArr, 0, bArr.length)));
            }
            if (zF || f(this.L)) {
                return;
            }
        }
        if (imageView != null) {
            imageView.setImageResource(R.color.transparent);
            imageView.setVisibility(4);
        }
    }

    public final boolean o() {
        if (!this.H) {
            return false;
        }
        d.h(this.D);
        return true;
    }

    @Override // android.view.View
    public final boolean onTrackballEvent(MotionEvent motionEvent) {
        if (!o() || this.G == null) {
            return false;
        }
        e(true);
        return true;
    }

    @Override // android.view.View
    public final boolean performClick() {
        i();
        return super.performClick();
    }

    public void setAnimationEnabled(boolean z2) {
        s sVar = this.D;
        if (sVar != null) {
            sVar.setAnimationEnabled(z2);
        }
    }

    public void setArtworkDisplayMode(int i) {
        d.g(i == 0 || this.f1616z != null);
        if (this.K != i) {
            this.K = i;
            n(false);
        }
    }

    public void setAspectRatioListener(a aVar) {
        AspectRatioFrameLayout aspectRatioFrameLayout = this.f1612v;
        d.h(aspectRatioFrameLayout);
        aspectRatioFrameLayout.setAspectRatioListener(aVar);
    }

    public void setControllerAutoShow(boolean z2) {
        this.Q = z2;
    }

    public void setControllerHideDuringAds(boolean z2) {
        this.R = z2;
    }

    public void setControllerHideOnTouch(boolean z2) {
        d.h(this.D);
        this.S = z2;
        l();
    }

    @Deprecated
    public void setControllerOnFullScreenModeChangedListener(i iVar) {
        s sVar = this.D;
        d.h(sVar);
        sVar.setOnFullScreenModeChangedListener(iVar);
    }

    public void setControllerShowTimeoutMs(int i) {
        s sVar = this.D;
        d.h(sVar);
        this.P = i;
        if (sVar.h()) {
            h(g());
        }
    }

    public void setControllerVisibilityListener(a0 a0Var) {
        this.I = a0Var;
        if (a0Var != null) {
            setControllerVisibilityListener((r) null);
        }
    }

    public void setCustomErrorMessage(CharSequence charSequence) {
        d.g(this.C != null);
        this.O = charSequence;
        m();
    }

    public void setDefaultArtwork(Drawable drawable) {
        if (this.L != drawable) {
            this.L = drawable;
            n(false);
        }
    }

    public void setErrorMessageProvider(n nVar) {
        if (nVar != null) {
            m();
        }
    }

    public void setFullscreenButtonClickListener(i4.b0 b0Var) {
        s sVar = this.D;
        d.h(sVar);
        sVar.setOnFullScreenModeChangedListener(this.f1611u);
    }

    public void setKeepContentOnPlayerReset(boolean z2) {
        if (this.N != z2) {
            this.N = z2;
            n(false);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:70:0x00c2, code lost:
    
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00c7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setPlayer(p1.w0 r11) {
        /*
            Method dump skipped, instruction units count: 232
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.ui.PlayerView.setPlayer(p1.w0):void");
    }

    public void setRepeatToggleModes(int i) {
        s sVar = this.D;
        d.h(sVar);
        sVar.setRepeatToggleModes(i);
    }

    public void setResizeMode(int i) {
        AspectRatioFrameLayout aspectRatioFrameLayout = this.f1612v;
        d.h(aspectRatioFrameLayout);
        aspectRatioFrameLayout.setResizeMode(i);
    }

    public void setShowBuffering(int i) {
        if (this.M != i) {
            this.M = i;
            k();
        }
    }

    public void setShowFastForwardButton(boolean z2) {
        s sVar = this.D;
        d.h(sVar);
        sVar.setShowFastForwardButton(z2);
    }

    @Deprecated
    public void setShowMultiWindowTimeBar(boolean z2) {
        s sVar = this.D;
        d.h(sVar);
        sVar.setShowMultiWindowTimeBar(z2);
    }

    public void setShowNextButton(boolean z2) {
        s sVar = this.D;
        d.h(sVar);
        sVar.setShowNextButton(z2);
    }

    public void setShowPlayButtonIfPlaybackIsSuppressed(boolean z2) {
        s sVar = this.D;
        d.h(sVar);
        sVar.setShowPlayButtonIfPlaybackIsSuppressed(z2);
    }

    public void setShowPreviousButton(boolean z2) {
        s sVar = this.D;
        d.h(sVar);
        sVar.setShowPreviousButton(z2);
    }

    public void setShowRewindButton(boolean z2) {
        s sVar = this.D;
        d.h(sVar);
        sVar.setShowRewindButton(z2);
    }

    public void setShowShuffleButton(boolean z2) {
        s sVar = this.D;
        d.h(sVar);
        sVar.setShowShuffleButton(z2);
    }

    public void setShowSubtitleButton(boolean z2) {
        s sVar = this.D;
        d.h(sVar);
        sVar.setShowSubtitleButton(z2);
    }

    public void setShowVrButton(boolean z2) {
        s sVar = this.D;
        d.h(sVar);
        sVar.setShowVrButton(z2);
    }

    public void setShutterBackgroundColor(int i) {
        View view = this.f1613w;
        if (view != null) {
            view.setBackgroundColor(i);
        }
    }

    @Deprecated
    public void setUseArtwork(boolean z2) {
        setArtworkDisplayMode(!z2 ? 1 : 0);
    }

    public void setUseController(boolean z2) {
        boolean z10 = true;
        s sVar = this.D;
        d.g((z2 && sVar == null) ? false : true);
        if (!z2 && !hasOnClickListeners()) {
            z10 = false;
        }
        setClickable(z10);
        if (this.H == z2) {
            return;
        }
        this.H = z2;
        if (o()) {
            sVar.setPlayer(this.G);
        } else if (sVar != null) {
            sVar.g();
            sVar.setPlayer(null);
        }
        l();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        View view = this.f1614x;
        if (view instanceof SurfaceView) {
            view.setVisibility(i);
        }
    }

    @Deprecated
    public void setControllerVisibilityListener(r rVar) {
        s sVar = this.D;
        d.h(sVar);
        CopyOnWriteArrayList copyOnWriteArrayList = sVar.f6284x;
        r rVar2 = this.J;
        if (rVar2 == rVar) {
            return;
        }
        if (rVar2 != null) {
            copyOnWriteArrayList.remove(rVar2);
        }
        this.J = rVar;
        if (rVar != null) {
            copyOnWriteArrayList.add(rVar);
            setControllerVisibilityListener((a0) null);
        }
    }
}
