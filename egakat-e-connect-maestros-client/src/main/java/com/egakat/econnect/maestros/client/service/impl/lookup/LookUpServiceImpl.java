package com.egakat.econnect.maestros.client.service.impl.lookup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.egakat.econnect.maestros.client.service.api.CanalLocalService;
import com.egakat.econnect.maestros.client.service.api.CiudadLocalService;
import com.egakat.econnect.maestros.client.service.api.ClienteLocalService;
import com.egakat.econnect.maestros.client.service.api.EstadoInventarioLocalService;
import com.egakat.econnect.maestros.client.service.api.ServicioLocalService;
import com.egakat.econnect.maestros.client.service.api.SubestadoInventarioLocalService;
import com.egakat.econnect.maestros.client.service.api.TerceroLocalService;
import com.egakat.econnect.maestros.client.service.api.lookup.LookUpService;
import com.egakat.econnect.maestros.client.service.impl.BodegaLocalServiceImpl;
import com.egakat.econnect.maestros.client.service.impl.ProductoLocalServiceImpl;
import com.egakat.econnect.maestros.client.service.impl.UnidadMedidaLocalServiceImpl;

import lombok.val;

@Service
public class LookUpServiceImpl implements LookUpService {

	@Autowired
	private ClienteLocalService clienteLocalService;

	@Autowired
	private ServicioLocalService servicioLocalService;

	@Autowired
	private CanalLocalService canalLocalService;

	@Autowired
	private TerceroLocalService terceroLocalService;

	@Autowired
	private CiudadLocalService ciudadLocalService;

	@Autowired
	private ProductoLocalServiceImpl productoLocalServiceImpl;

	@Autowired
	private UnidadMedidaLocalServiceImpl unidadLocalService;

	@Autowired
	private BodegaLocalServiceImpl bodegaLocalService;

	@Autowired
	private EstadoInventarioLocalService estadoInventarioLocalService;

	@Autowired
	private SubestadoInventarioLocalService subestadoInventarioLocalService;

	@Override
	public Long findClienteIdByCodigo(String codigo) {
		Long result = null;
		try {
			val model = clienteLocalService.getByCodigo(codigo);
			result = model.getId();
		} catch (HttpClientErrorException e) {
			throwIf(e);
		}
		return result;
	}

	@Override
	public Long findClienteIdByNumeroIndentificacion(String numeroIdentificacion) {
		Long result = null;
		try {
			val model = clienteLocalService.getByNumeroIdentificacion(numeroIdentificacion);
			result = model.getId();
		} catch (HttpClientErrorException e) {
			throwIf(e);
		}
		return result;
	}
	
	@Override
	public Long findClienteIdByCodigoWms(String codigo) {
		Long result = null;
		try {
			val model = clienteLocalService.getByCodigoWms(codigo);
			result = model.getId();
		} catch (HttpClientErrorException e) {
			throwIf(e);
		}
		return result;
	}
	

	@Override
	public Long findServicioIdByCodigo(String codigo) {
		Long result = null;
		try {
			val model = servicioLocalService.getByCodigo(codigo);
			result = model.getId();
		} catch (HttpClientErrorException e) {
			throwIf(e);
		}
		return result;
	}

	@Override
	public Long findCanalIdByCodigo(String codigo) {
		Long result = null;
		try {
			val model = canalLocalService.getByCodigo(codigo);
			result = model.getId();
		} catch (HttpClientErrorException e) {
			throwIf(e);
		}
		return result;
	}

	@Override
	public Long findTerceroIdByIdAndNumeroIdentificacion(long cliente, String numeroIdentificacion) {
		Long result = null;
		try {
			val model = clienteLocalService.getTerceroByClienteIdAndNumeroIdentificacion(cliente, numeroIdentificacion);
			result = model.getId();
		} catch (HttpClientErrorException e) {
			throwIf(e);
		}
		return result;
	}

	@Override
	public Long findPuntoIdByTerceroIdAndPuntoCodigo(long tercero, String codigo) {
		Long result = null;
		try {
			val model = terceroLocalService.getPuntoByTerceroIdAndPuntoCodigo(tercero, codigo);
			result = model.getId();
		} catch (HttpClientErrorException e) {
			throwIf(e);
		}
		return result;
	}

	@Override
	public Long findCiudadIdByCodigo(String codigo) {
		Long result = null;
		try {
			val model = ciudadLocalService.getByCodigo(codigo);
			result = model.getId();
		} catch (HttpClientErrorException e) {
			throwIf(e);
		}
		return result;
	}

	@Override
	public Long findCiudadIdByNombreAlterno(String nombreAlterno) {
		Long result = null;
		try {
			val model = ciudadLocalService.getByNombreAlterno(nombreAlterno);
			result = model.getId();
		} catch (HttpClientErrorException e) {
			throwIf(e);
		}
		return result;
	}

	@Override
	public Long findProductoIdByClienteIdAndCodigo(long cliente, String codigo) {
		Long result = null;
		try {
			val model = clienteLocalService.getProductoByClienteIdAndProductoCodigo(cliente, codigo);
			result = model.getId();
		} catch (HttpClientErrorException e) {
			throwIf(e);
		}
		return result;
	}

	@Override
	public Long findUnidadMedidaDeReciboIdByProductoIdAndBodegaId(long producto, long bodega) {
		Long result = null;
		try {
			val models = productoLocalServiceImpl.getMedidasByProductoIdAndBodegaId(producto, bodega);
			val model = models.stream().filter(a -> a.isReceiveFlag()).findFirst();
			if (model.isPresent()) {
				result = model.get().getIdUnidadMedida();
			}
		} catch (HttpClientErrorException e) {
			throwIf(e);
		}
		return result;
	}

	@Override
	public Long findUnidadMedidaIdByCodigo(String codigo) {
		Long result = null;
		try {
			val model = unidadLocalService.getByCodigo(codigo);
			result = model.getId();
		} catch (HttpClientErrorException e) {
			throwIf(e);
		}
		return result;
	}

	@Override
	public Long findBodegaIdByCodigo(String codigo) {
		Long result = null;
		try {
			val model = bodegaLocalService.getByCodigo(codigo);
			result = model.getId();
		} catch (HttpClientErrorException e) {
			throwIf(e);
		}
		return result;
	}

	@Override
	public String findEstadoInventarioIdByCodigo(String codigo) {
		String result = null;
		try {
			val model = estadoInventarioLocalService.findOneById(codigo);
			result = model.getId();
		} catch (HttpClientErrorException e) {
			throwIf(e);
		}
		return result;
	}

	@Override
	public String findSubestadoInventarioIdByCodigo(String codigo) {
		String result = null;
		try {
			val model = subestadoInventarioLocalService.findOneById(codigo);
			result = model.getId();
		} catch (HttpClientErrorException e) {
			throwIf(e);
		}
		return result;
	}

	private void throwIf(HttpClientErrorException e) {
		if (e.getRawStatusCode() == 404) {
			return;
		}
		throw e;
	}
}
