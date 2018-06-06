package com.egakat.econnect.config.client.service.api;

import com.egakat.core.web.client.service.api.LocalQueryService;
import com.egakat.econnect.config.dto.ConfiguracionDto;
import com.egakat.econnect.config.dto.GrupoConfiguracionDto;

public interface GrupoConfiguracionLocalService extends LocalQueryService<GrupoConfiguracionDto,Long> {
	
	static final String CONFIGURACION_ETL_FILES_DIRECTORIOS = "com-egakat-etl-files-directorios";

	static final String CONFIGURACION_ETL_FILES_REGEXP = "com-egakat-etl-files-regexp";

	static final String CONFIGURACION_ETL_FILES_REST_URL_BASE = "com-egakat-etl-files-rest-url-base";

	GrupoConfiguracionDto getByCodigo(String codigo);
	
	ConfiguracionDto getConfiguracionByGrupoConfiguracionIdAndConfiguracionCodigo(long grupoConfiguracion, String codigo);
}