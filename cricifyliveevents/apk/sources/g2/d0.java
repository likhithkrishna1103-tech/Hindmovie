package g2;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.TextureView;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d0 implements y2.c0, i2.l, SurfaceHolder.Callback, TextureView.SurfaceTextureListener {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ g0 f4651v;

    public d0(g0 g0Var) {
        this.f4651v = g0Var;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i10) {
        Surface surface = new Surface(surfaceTexture);
        g0 g0Var = this.f4651v;
        g0Var.J1(surface);
        g0Var.f4701m0 = surface;
        g0Var.B1(i, i10);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        g0 g0Var = this.f4651v;
        g0Var.J1(null);
        g0Var.B1(0, 0);
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i10) {
        this.f4651v.B1(i, i10);
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i10, int i11) {
        this.f4651v.B1(i10, i11);
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        g0 g0Var = this.f4651v;
        if (g0Var.f4703p0) {
            g0Var.J1(surfaceHolder.getSurface());
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        g0 g0Var = this.f4651v;
        if (g0Var.f4703p0) {
            g0Var.J1(null);
        }
        g0Var.B1(0, 0);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
