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
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import m4.a;
import m4.b0;
import m4.d0;
import m4.f0;
import m4.g;
import m4.h0;
import m4.j0;
import m4.l0;
import m4.p;
import m4.q;
import m4.v;
import m4.w;
import m4.x;
import m4.y;
import m4.z;
import ua.i0;
import v1.m;
import v1.r0;
import v1.r1;
import v1.w0;
import y1.a0;
import y1.d;
import y2.s;
import z2.k;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class PlayerView extends FrameLayout {
    public static final /* synthetic */ int U = 0;
    public final ImageView A;
    public final SubtitleView B;
    public final View C;
    public final TextView D;
    public final q E;
    public final FrameLayout F;
    public final FrameLayout G;
    public w0 H;
    public boolean I;
    public y J;
    public p K;
    public int L;
    public Drawable M;
    public int N;
    public boolean O;
    public CharSequence P;
    public int Q;
    public boolean R;
    public boolean S;
    public boolean T;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final x f1305v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final AspectRatioFrameLayout f1306w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final View f1307x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final View f1308y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final boolean f1309z;

    /* JADX WARN: Multi-variable type inference failed */
    public PlayerView(Context context, AttributeSet attributeSet) {
        int i;
        int i10;
        boolean z10;
        boolean z11;
        boolean z12;
        int i11;
        int i12;
        int i13;
        int i14;
        boolean z13;
        int i15;
        boolean z14;
        boolean z15;
        int i16;
        boolean z16;
        super(context, attributeSet, 0);
        x xVar = new x(this);
        this.f1305v = xVar;
        if (isInEditMode()) {
            this.f1306w = null;
            this.f1307x = null;
            this.f1308y = null;
            this.f1309z = false;
            this.A = null;
            this.B = null;
            this.C = null;
            this.D = null;
            this.E = null;
            this.F = null;
            this.G = null;
            ImageView imageView = new ImageView(context);
            if (a0.f14551a >= 23) {
                Resources resources = getResources();
                imageView.setImageDrawable(resources.getDrawable(d0.exo_edit_mode_logo, context.getTheme()));
                imageView.setBackgroundColor(resources.getColor(b0.exo_edit_mode_background_color, null));
            } else {
                Resources resources2 = getResources();
                imageView.setImageDrawable(resources2.getDrawable(d0.exo_edit_mode_logo, context.getTheme()));
                imageView.setBackgroundColor(resources2.getColor(b0.exo_edit_mode_background_color));
            }
            addView(imageView);
            return;
        }
        int i17 = h0.exo_player_view;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, l0.PlayerView, 0, 0);
            try {
                boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(l0.PlayerView_shutter_background_color);
                int color = typedArrayObtainStyledAttributes.getColor(l0.PlayerView_shutter_background_color, 0);
                int resourceId = typedArrayObtainStyledAttributes.getResourceId(l0.PlayerView_player_layout_id, i17);
                boolean z17 = typedArrayObtainStyledAttributes.getBoolean(l0.PlayerView_use_artwork, true);
                int i18 = typedArrayObtainStyledAttributes.getInt(l0.PlayerView_artwork_display_mode, 1);
                int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(l0.PlayerView_default_artwork, 0);
                boolean z18 = typedArrayObtainStyledAttributes.getBoolean(l0.PlayerView_use_controller, true);
                int i19 = typedArrayObtainStyledAttributes.getInt(l0.PlayerView_surface_type, 1);
                int i20 = typedArrayObtainStyledAttributes.getInt(l0.PlayerView_resize_mode, 0);
                int i21 = typedArrayObtainStyledAttributes.getInt(l0.PlayerView_show_timeout, 5000);
                boolean z19 = typedArrayObtainStyledAttributes.getBoolean(l0.PlayerView_hide_on_touch, true);
                boolean z20 = typedArrayObtainStyledAttributes.getBoolean(l0.PlayerView_auto_show, true);
                int integer = typedArrayObtainStyledAttributes.getInteger(l0.PlayerView_show_buffering, 0);
                this.O = typedArrayObtainStyledAttributes.getBoolean(l0.PlayerView_keep_content_on_player_reset, this.O);
                boolean z21 = typedArrayObtainStyledAttributes.getBoolean(l0.PlayerView_hide_during_ads, true);
                typedArrayObtainStyledAttributes.recycle();
                i12 = i20;
                z11 = z20;
                z15 = zHasValue;
                i11 = i19;
                i17 = resourceId;
                z10 = z19;
                i = i21;
                z14 = z18;
                z12 = z21;
                i15 = i18;
                i10 = integer;
                i14 = color;
                i13 = resourceId2;
                z13 = z17;
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes.recycle();
                throw th;
            }
        } else {
            i = 5000;
            i10 = 0;
            z10 = true;
            z11 = true;
            z12 = true;
            i11 = 1;
            i12 = 0;
            i13 = 0;
            i14 = 0;
            z13 = true;
            i15 = 1;
            z14 = true;
            z15 = false;
        }
        LayoutInflater.from(context).inflate(i17, this);
        setDescendantFocusability(262144);
        AspectRatioFrameLayout aspectRatioFrameLayout = (AspectRatioFrameLayout) findViewById(f0.exo_content_frame);
        this.f1306w = aspectRatioFrameLayout;
        if (aspectRatioFrameLayout != null) {
            aspectRatioFrameLayout.setResizeMode(i12);
        }
        View viewFindViewById = findViewById(f0.exo_shutter);
        this.f1307x = viewFindViewById;
        if (viewFindViewById != null && z15) {
            viewFindViewById.setBackgroundColor(i14);
        }
        if (aspectRatioFrameLayout == null || i11 == 0) {
            i16 = 0;
            this.f1308y = null;
            z16 = false;
        } else {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            if (i11 == 2) {
                this.f1308y = new TextureView(context);
            } else if (i11 == 3) {
                try {
                    int i22 = k.G;
                    this.f1308y = (View) k.class.getConstructor(Context.class).newInstance(context);
                    z16 = true;
                    this.f1308y.setLayoutParams(layoutParams);
                    this.f1308y.setOnClickListener(xVar);
                    i16 = 0;
                    this.f1308y.setClickable(false);
                    aspectRatioFrameLayout.addView(this.f1308y, 0);
                } catch (Exception e9) {
                    throw new IllegalStateException("spherical_gl_surface_view requires an ExoPlayer dependency", e9);
                }
            } else if (i11 != 4) {
                SurfaceView surfaceView = new SurfaceView(context);
                if (a0.f14551a >= 34) {
                    w.a(surfaceView);
                }
                this.f1308y = surfaceView;
            } else {
                try {
                    int i23 = s.f14726w;
                    this.f1308y = (View) s.class.getConstructor(Context.class).newInstance(context);
                } catch (Exception e10) {
                    throw new IllegalStateException("video_decoder_gl_surface_view requires an ExoPlayer dependency", e10);
                }
            }
            z16 = false;
            this.f1308y.setLayoutParams(layoutParams);
            this.f1308y.setOnClickListener(xVar);
            i16 = 0;
            this.f1308y.setClickable(false);
            aspectRatioFrameLayout.addView(this.f1308y, 0);
        }
        this.f1309z = z16;
        this.F = (FrameLayout) findViewById(f0.exo_ad_overlay);
        this.G = (FrameLayout) findViewById(f0.exo_overlay);
        ImageView imageView2 = (ImageView) findViewById(f0.exo_artwork);
        this.A = imageView2;
        this.L = (!z13 || i15 == 0 || imageView2 == null) ? i16 : i15;
        if (i13 != 0) {
            this.M = getContext().getDrawable(i13);
        }
        SubtitleView subtitleView = (SubtitleView) findViewById(f0.exo_subtitles);
        this.B = subtitleView;
        if (subtitleView != null) {
            subtitleView.a();
            subtitleView.b();
        }
        View viewFindViewById2 = findViewById(f0.exo_buffering);
        this.C = viewFindViewById2;
        if (viewFindViewById2 != null) {
            viewFindViewById2.setVisibility(8);
        }
        this.N = i10;
        TextView textView = (TextView) findViewById(f0.exo_error_message);
        this.D = textView;
        if (textView != null) {
            textView.setVisibility(8);
        }
        q qVar = (q) findViewById(f0.exo_controller);
        View viewFindViewById3 = findViewById(f0.exo_controller_placeholder);
        if (qVar != null) {
            this.E = qVar;
        } else if (viewFindViewById3 != null) {
            q qVar2 = new q(context, attributeSet);
            this.E = qVar2;
            qVar2.setId(f0.exo_controller);
            qVar2.setLayoutParams(viewFindViewById3.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) viewFindViewById3.getParent();
            int iIndexOfChild = viewGroup.indexOfChild(viewFindViewById3);
            viewGroup.removeView(viewFindViewById3);
            viewGroup.addView(qVar2, iIndexOfChild);
        } else {
            this.E = null;
        }
        q qVar3 = this.E;
        this.Q = qVar3 != null ? i : i16;
        this.T = z10;
        this.R = z11;
        this.S = z12;
        this.I = (!z14 || qVar3 == null) ? i16 : 1;
        if (qVar3 != null) {
            v vVar = qVar3.f8248v;
            int i24 = vVar.f8292z;
            if (i24 != 3 && i24 != 2) {
                vVar.f();
                vVar.i(2);
            }
            this.E.f8254y.add(xVar);
        }
        if (z14) {
            setClickable(true);
        }
        k();
    }

    public static void a(TextureView textureView) {
        Matrix matrix = new Matrix();
        textureView.getWidth();
        textureView.getHeight();
        textureView.setTransform(matrix);
    }

    public final void b() {
        q qVar = this.E;
        if (qVar != null) {
            qVar.g();
        }
    }

    public final boolean c() {
        w0 w0Var = this.H;
        return w0Var != null && w0Var.Z(16) && this.H.l() && this.H.w();
    }

    public final void d(boolean z10) {
        if (!(c() && this.S) && n()) {
            q qVar = this.E;
            boolean z11 = qVar.h() && qVar.getShowTimeoutMs() <= 0;
            boolean zF = f();
            if (z10 || z11 || zF) {
                g(zF);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        w0 w0Var = this.H;
        if (w0Var != null && w0Var.Z(16) && this.H.l()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        int keyCode = keyEvent.getKeyCode();
        boolean z10 = keyCode == 19 || keyCode == 270 || keyCode == 22 || keyCode == 271 || keyCode == 20 || keyCode == 269 || keyCode == 21 || keyCode == 268 || keyCode == 23;
        q qVar = this.E;
        if (z10 && n() && !qVar.h()) {
            d(true);
            return true;
        }
        if ((n() && qVar.d(keyEvent)) || super.dispatchKeyEvent(keyEvent)) {
            d(true);
            return true;
        }
        if (z10 && n()) {
            d(true);
        }
        return false;
    }

    public final boolean e(Drawable drawable) {
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > 0 && intrinsicHeight > 0) {
                float width = intrinsicWidth / intrinsicHeight;
                ImageView.ScaleType scaleType = ImageView.ScaleType.FIT_XY;
                if (this.L == 2) {
                    width = getWidth() / getHeight();
                    scaleType = ImageView.ScaleType.CENTER_CROP;
                }
                AspectRatioFrameLayout aspectRatioFrameLayout = this.f1306w;
                if (aspectRatioFrameLayout != null) {
                    aspectRatioFrameLayout.setAspectRatio(width);
                }
                ImageView imageView = this.A;
                imageView.setScaleType(scaleType);
                imageView.setImageDrawable(drawable);
                imageView.setVisibility(0);
                return true;
            }
        }
        return false;
    }

    public final boolean f() {
        w0 w0Var = this.H;
        if (w0Var == null) {
            return true;
        }
        int iE = w0Var.E();
        if (!this.R) {
            return false;
        }
        if (this.H.Z(17) && this.H.v0().p()) {
            return false;
        }
        if (iE != 1 && iE != 4) {
            w0 w0Var2 = this.H;
            w0Var2.getClass();
            if (w0Var2.w()) {
                return false;
            }
        }
        return true;
    }

    public final void g(boolean z10) {
        if (n()) {
            int i = z10 ? 0 : this.Q;
            q qVar = this.E;
            qVar.setShowTimeoutMs(i);
            v vVar = qVar.f8248v;
            q qVar2 = vVar.f8269a;
            if (!qVar2.i()) {
                qVar2.setVisibility(0);
                qVar2.j();
                View view = qVar2.J;
                if (view != null) {
                    view.requestFocus();
                }
            }
            vVar.k();
        }
    }

    public List<r0> getAdOverlayInfos() {
        ArrayList arrayList = new ArrayList();
        FrameLayout frameLayout = this.G;
        if (frameLayout != null) {
            arrayList.add(new r0(frameLayout));
        }
        q qVar = this.E;
        if (qVar != null) {
            arrayList.add(new r0(qVar));
        }
        return i0.k(arrayList);
    }

    public ViewGroup getAdViewGroup() {
        FrameLayout frameLayout = this.F;
        d.i(frameLayout, "exo_ad_overlay must be present for ad playback");
        return frameLayout;
    }

    public int getArtworkDisplayMode() {
        return this.L;
    }

    public boolean getControllerAutoShow() {
        return this.R;
    }

    public boolean getControllerHideOnTouch() {
        return this.T;
    }

    public int getControllerShowTimeoutMs() {
        return this.Q;
    }

    public Drawable getDefaultArtwork() {
        return this.M;
    }

    public FrameLayout getOverlayFrameLayout() {
        return this.G;
    }

    public w0 getPlayer() {
        return this.H;
    }

    public int getResizeMode() {
        AspectRatioFrameLayout aspectRatioFrameLayout = this.f1306w;
        d.h(aspectRatioFrameLayout);
        return aspectRatioFrameLayout.getResizeMode();
    }

    public SubtitleView getSubtitleView() {
        return this.B;
    }

    @Deprecated
    public boolean getUseArtwork() {
        return this.L != 0;
    }

    public boolean getUseController() {
        return this.I;
    }

    public View getVideoSurfaceView() {
        return this.f1308y;
    }

    public final void h() {
        if (!n() || this.H == null) {
            return;
        }
        q qVar = this.E;
        if (!qVar.h()) {
            d(true);
        } else if (this.T) {
            qVar.g();
        }
    }

    public final void i() {
        w0 w0Var = this.H;
        r1 r1VarR = w0Var != null ? w0Var.R() : r1.f12978d;
        int i = r1VarR.f12981a;
        int i10 = r1VarR.f12982b;
        float f = (i10 == 0 || i == 0) ? 0.0f : (i * r1VarR.f12983c) / i10;
        View view = this.f1308y;
        if (view instanceof TextureView) {
            a((TextureView) view);
        }
        float f10 = this.f1309z ? 0.0f : f;
        AspectRatioFrameLayout aspectRatioFrameLayout = this.f1306w;
        if (aspectRatioFrameLayout != null) {
            aspectRatioFrameLayout.setAspectRatio(f10);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j() {
        /*
            r5 = this;
            android.view.View r0 = r5.C
            if (r0 == 0) goto L29
            v1.w0 r1 = r5.H
            r2 = 0
            if (r1 == 0) goto L20
            int r1 = r1.E()
            r3 = 2
            if (r1 != r3) goto L20
            int r1 = r5.N
            r4 = 1
            if (r1 == r3) goto L21
            if (r1 != r4) goto L20
            v1.w0 r1 = r5.H
            boolean r1 = r1.w()
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
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.ui.PlayerView.j():void");
    }

    public final void k() {
        q qVar = this.E;
        if (qVar == null || !this.I) {
            setContentDescription(null);
        } else if (qVar.h()) {
            setContentDescription(this.T ? getResources().getString(j0.exo_controls_hide) : null);
        } else {
            setContentDescription(getResources().getString(j0.exo_controls_show));
        }
    }

    public final void l() {
        TextView textView = this.D;
        if (textView != null) {
            CharSequence charSequence = this.P;
            if (charSequence != null) {
                textView.setText(charSequence);
                textView.setVisibility(0);
            } else {
                w0 w0Var = this.H;
                if (w0Var != null) {
                    w0Var.h();
                }
                textView.setVisibility(8);
            }
        }
    }

    public final void m(boolean z10) {
        byte[] bArr;
        w0 w0Var = this.H;
        View view = this.f1307x;
        ImageView imageView = this.A;
        boolean zE = false;
        if (w0Var == null || !w0Var.Z(30) || w0Var.G().f12882a.isEmpty()) {
            if (this.O) {
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
        if (z10 && !this.O && view != null) {
            view.setVisibility(0);
        }
        if (w0Var.G().a(2)) {
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
        if (this.L != 0) {
            d.h(imageView);
            if (w0Var.Z(18) && (bArr = w0Var.P0().f12773k) != null) {
                zE = e(new BitmapDrawable(getResources(), BitmapFactory.decodeByteArray(bArr, 0, bArr.length)));
            }
            if (zE || e(this.M)) {
                return;
            }
        }
        if (imageView != null) {
            imageView.setImageResource(R.color.transparent);
            imageView.setVisibility(4);
        }
    }

    public final boolean n() {
        if (!this.I) {
            return false;
        }
        d.h(this.E);
        return true;
    }

    @Override // android.view.View
    public final boolean onTrackballEvent(MotionEvent motionEvent) {
        if (!n() || this.H == null) {
            return false;
        }
        d(true);
        return true;
    }

    @Override // android.view.View
    public final boolean performClick() {
        h();
        return super.performClick();
    }

    public void setAnimationEnabled(boolean z10) {
        q qVar = this.E;
        if (qVar != null) {
            qVar.setAnimationEnabled(z10);
        }
    }

    public void setArtworkDisplayMode(int i) {
        d.g(i == 0 || this.A != null);
        if (this.L != i) {
            this.L = i;
            m(false);
        }
    }

    public void setAspectRatioListener(a aVar) {
        AspectRatioFrameLayout aspectRatioFrameLayout = this.f1306w;
        d.h(aspectRatioFrameLayout);
        aspectRatioFrameLayout.setAspectRatioListener(aVar);
    }

    public void setControllerAutoShow(boolean z10) {
        this.R = z10;
    }

    public void setControllerHideDuringAds(boolean z10) {
        this.S = z10;
    }

    public void setControllerHideOnTouch(boolean z10) {
        d.h(this.E);
        this.T = z10;
        k();
    }

    @Deprecated
    public void setControllerOnFullScreenModeChangedListener(g gVar) {
        q qVar = this.E;
        d.h(qVar);
        qVar.setOnFullScreenModeChangedListener(gVar);
    }

    public void setControllerShowTimeoutMs(int i) {
        q qVar = this.E;
        d.h(qVar);
        this.Q = i;
        if (qVar.h()) {
            g(f());
        }
    }

    public void setControllerVisibilityListener(y yVar) {
        this.J = yVar;
        if (yVar != null) {
            setControllerVisibilityListener((p) null);
        }
    }

    public void setCustomErrorMessage(CharSequence charSequence) {
        d.g(this.D != null);
        this.P = charSequence;
        l();
    }

    public void setDefaultArtwork(Drawable drawable) {
        if (this.M != drawable) {
            this.M = drawable;
            m(false);
        }
    }

    public void setErrorMessageProvider(m mVar) {
        if (mVar != null) {
            l();
        }
    }

    public void setFullscreenButtonClickListener(z zVar) {
        q qVar = this.E;
        d.h(qVar);
        qVar.setOnFullScreenModeChangedListener(this.f1305v);
    }

    public void setKeepContentOnPlayerReset(boolean z10) {
        if (this.O != z10) {
            this.O = z10;
            m(false);
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
    public void setPlayer(v1.w0 r11) {
        /*
            Method dump skipped, instruction units count: 232
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.ui.PlayerView.setPlayer(v1.w0):void");
    }

    public void setRepeatToggleModes(int i) {
        q qVar = this.E;
        d.h(qVar);
        qVar.setRepeatToggleModes(i);
    }

    public void setResizeMode(int i) {
        AspectRatioFrameLayout aspectRatioFrameLayout = this.f1306w;
        d.h(aspectRatioFrameLayout);
        aspectRatioFrameLayout.setResizeMode(i);
    }

    public void setShowBuffering(int i) {
        if (this.N != i) {
            this.N = i;
            j();
        }
    }

    public void setShowFastForwardButton(boolean z10) {
        q qVar = this.E;
        d.h(qVar);
        qVar.setShowFastForwardButton(z10);
    }

    @Deprecated
    public void setShowMultiWindowTimeBar(boolean z10) {
        q qVar = this.E;
        d.h(qVar);
        qVar.setShowMultiWindowTimeBar(z10);
    }

    public void setShowNextButton(boolean z10) {
        q qVar = this.E;
        d.h(qVar);
        qVar.setShowNextButton(z10);
    }

    public void setShowPlayButtonIfPlaybackIsSuppressed(boolean z10) {
        q qVar = this.E;
        d.h(qVar);
        qVar.setShowPlayButtonIfPlaybackIsSuppressed(z10);
    }

    public void setShowPreviousButton(boolean z10) {
        q qVar = this.E;
        d.h(qVar);
        qVar.setShowPreviousButton(z10);
    }

    public void setShowRewindButton(boolean z10) {
        q qVar = this.E;
        d.h(qVar);
        qVar.setShowRewindButton(z10);
    }

    public void setShowShuffleButton(boolean z10) {
        q qVar = this.E;
        d.h(qVar);
        qVar.setShowShuffleButton(z10);
    }

    public void setShowSubtitleButton(boolean z10) {
        q qVar = this.E;
        d.h(qVar);
        qVar.setShowSubtitleButton(z10);
    }

    public void setShowVrButton(boolean z10) {
        q qVar = this.E;
        d.h(qVar);
        qVar.setShowVrButton(z10);
    }

    public void setShutterBackgroundColor(int i) {
        View view = this.f1307x;
        if (view != null) {
            view.setBackgroundColor(i);
        }
    }

    @Deprecated
    public void setUseArtwork(boolean z10) {
        setArtworkDisplayMode(!z10 ? 1 : 0);
    }

    public void setUseController(boolean z10) {
        boolean z11 = true;
        q qVar = this.E;
        d.g((z10 && qVar == null) ? false : true);
        if (!z10 && !hasOnClickListeners()) {
            z11 = false;
        }
        setClickable(z11);
        if (this.I == z10) {
            return;
        }
        this.I = z10;
        if (n()) {
            qVar.setPlayer(this.H);
        } else if (qVar != null) {
            qVar.g();
            qVar.setPlayer(null);
        }
        k();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        View view = this.f1308y;
        if (view instanceof SurfaceView) {
            view.setVisibility(i);
        }
    }

    @Deprecated
    public void setControllerVisibilityListener(p pVar) {
        q qVar = this.E;
        d.h(qVar);
        CopyOnWriteArrayList copyOnWriteArrayList = qVar.f8254y;
        p pVar2 = this.K;
        if (pVar2 == pVar) {
            return;
        }
        if (pVar2 != null) {
            copyOnWriteArrayList.remove(pVar2);
        }
        this.K = pVar;
        if (pVar != null) {
            copyOnWriteArrayList.add(pVar);
            setControllerVisibilityListener((y) null);
        }
    }
}
